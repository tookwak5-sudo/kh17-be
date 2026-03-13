package oop.inherit5;

public class MpFile extends File{
	public MpFile(String filename, long filesize) {
		super(filename, filesize);
	}
	public void forward() {
		System.out.println("빨리감기 기능");
	}
	public void rewind() {
		System.out.println("되감기 기능");
	}
}
