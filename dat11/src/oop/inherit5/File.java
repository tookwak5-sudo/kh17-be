package oop.inherit5;

public class File {
	protected String filename; //파일마다 규칙이 다르니 각자 설정 가능하도록
	private long filesize; //0 이상이라고 규칙을 정하고 그 누구도 못바꾸게!!
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		if(filesize < 0L) return;
		this.filesize = filesize;
	}
	
	// 가상의 Getter - 파일 크기별로 뒤에 단위를 변경해서 반환
	public String getFilesizeStr() {  // Str이 보통 string을 이야기함
		if(this.filesize < 1024L) 
			return this.filesize + "byte";
		if(this.filesize < 1024L * 1024L) 
			return this.filesize /1024L + "KB";
		if(this.filesize < 1024L * 1024L * 1024L)
			return this.filesize / 1024L/1024L + "MB";
		if(this.filesize < 1024L * 1024L * 1024L * 1024L)
			return this.filesize / 1024L/1024L/1024L + "GB";
		return this.filesize + "byte"; //나머지는 바이트
	}
	
	//생성자 반드시 파일 이름 크기를 가짐
	public File(String filename, long filesize) {
		this.setFilename(filename);
		this.setFilesize(filesize);
	}
	
	//메소드
	public void execute() {
		System.out.println("["+ this.getFilename() + "]파일 실행 기능");
	}
	public void information() {
		System.out.println("<파일 정보>");
		System.out.println("이름 : "  + this.getFilename());
		System.out.println("크기 : " + this.getFilesizeStr());
	}
}
