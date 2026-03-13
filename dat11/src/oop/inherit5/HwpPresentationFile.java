package oop.inherit5;

public class HwpPresentationFile extends PresentationFile{

	public HwpPresentationFile(String filename, int filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}

	public HwpPresentationFile(String filename, int filesize) {
		super(filename, filesize);
	}
	
	public void preview() {
		System.out.println("미리보기 기능");
	}
}
