package oop.inherit5;

public class Test01상속예제 {
	public static void main(String[] args) {

		Mp4MpFile m4 = new Mp4MpFile("테스트mp4", 23456L, 2.0F);
		m4.execute(); // 실행
		m4.forward(); // 빨리감기
		m4.rewind(); // 되감기
		m4.information(); //정보출력

		Mp3MpFile m3 = new Mp3MpFile("봄여름가을겨울", 154523L, 200);
		m3.execute();
		m3.forward();
		m3.rewind();
		m3.information();
		
		HwpPresentationFile h = new HwpPresentationFile("자소서", 50);
		h.execute();
		h.preview();
		h.information();
		
		PptPresentationFile p = new PptPresentationFile("코딩 잘하는 법", 10, 10);
		p.execute();
		p.slideShow();
		p.information();
	}
}
