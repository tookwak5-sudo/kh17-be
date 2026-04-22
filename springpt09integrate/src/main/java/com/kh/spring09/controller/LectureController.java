package com.kh.spring09.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.LectureDao;
import com.kh.spring09.dto.LectureDto;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.service.AttachService;
import com.kh.spring09.vo.PageVo;

@Controller
@RequestMapping("/lecture")
public class LectureController {
	@Autowired
	private LectureDao lectureDao;
	
	@Autowired
	private AttachService attachService;
	
	@GetMapping("/insert")
	public String insert() {
		return "lecture/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute LectureDto lectureDto
				//RequestParam에 value를 적으면 수신할 파라미터명과 변수명을 분리할 수 있다
						,@RequestParam(value = "attach") List<MultipartFile> attachList) throws IOException, Exception { //이름과 사용할 이름을 분리
		
		//번호 생성 후 강좌를 등록하도록 처리(이미지의 유무와 관계없이)
		int lectureNo = lectureDao.sequence(); // 모든 등록이 sequence를 미리 등록하는 형태
		lectureDto.setLectureNo(lectureNo);
		lectureDao.insert(lectureDto);
		
		for(MultipartFile attach : attachList) {
			if(!attach.isEmpty()) { // 만약에 이미지가 있다면
				int attachNo = attachService.save(attach); 
				lectureDao.connect(lectureNo, attachNo);
			}
		}
		
//		return "redirect:/lecture/insert6"; //절대
		return "redirect:./insertComplete"; //상대
	}
	
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "lecture/insertComplete";
	}
	
	@RequestMapping("/list")
	public String list(@ModelAttribute PageVo pageVo ,Model model) {
		List<LectureDto> list = lectureDao.selectList(pageVo);
		
		model.addAttribute("list", list);
		
		int count = lectureDao.count(pageVo);
		pageVo.setCount(count);
		model.addAttribute("pageVo", pageVo);
		
		return "lecture/list";
	}
	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException("존재하지 않는 강좌 정보");
		model.addAttribute("lectureDto", lectureDto);
		return "lecture/detail";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException("존재하지 않는 강좌 정보");
		
		lectureDao.delete(lectureNo);
		return "redirect:./list";
//		return "redirect:lecture/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int lectureNo, Model model) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException("존재하지 않는 강좌 정보");
		
		model.addAttribute("lectureDto",lectureDto);
		return "lecture/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute LectureDto lectureDto) {
		lectureDao.update(lectureDto);
		return "redirect:./detail?lectureNo=" + lectureDto.getLectureNo();
	}
}
