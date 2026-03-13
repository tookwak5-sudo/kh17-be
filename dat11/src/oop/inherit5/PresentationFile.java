package oop.inherit5;

public class PresentationFile extends File{
	//추가필드
	private int pagesize; // 1장 이상 이어야 하며 무조건 전부다 동일
	//protected int pagesize; // 최대page를 설정해야 한다면 protected

	public void setPagesize(int pagesize) {
		if(pagesize <1) return;
		this.pagesize = pagesize;
	}
	public int getPagesize() {
		return pagesize;
	}

	//생성자 - 페이지수 유무에 따른 2가지
	public PresentationFile(String filename, int filesize) { //페이지 수 미 설정 시 1
		super(filename, filesize);
		this.setPagesize(1);
	}
	public PresentationFile(String filename, int filesize, int pagesize) {
		super(filename, filesize);
		this.setPagesize(pagesize);
	}
	
	//- @로 시작하는 코드를 어노테이션(Annotation)이라고 부름
	//- 바로 뒤 코드가 무엇인지 명시하는 역할 (like: 명찰이나 해시태크) 있어도 되고 없어도됨
	//- 다만 이 코드가 있으면 information의 오타가 있으면 오류가 생김
	@Override
	public void information() {
		super.information();
		System.out.println("페이지 수 : " + this.getPagesize() + "p");
	}
}
