package oop.inherit5;

public class PptPresentationFile extends PresentationFile{
	
	public PptPresentationFile(String filename, int filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}
	public PptPresentationFile(String filename, int filesize) {
		super(filename, filesize);
	}
	public void slideShow() {
		System.out.println("슬라이드쇼 기능");
	}
}
