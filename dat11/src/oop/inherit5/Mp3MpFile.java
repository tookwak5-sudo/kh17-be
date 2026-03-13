package oop.inherit5;

public class Mp3MpFile extends MpFile{
	//추가필드
	private int duration;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	//가상의 getter
	public String getDurationString() {
		if(this.duration < 60) 
			return this.duration + "s";
		if(this.duration < 60 *  60)
			return this.duration/60 + "m" + this.duration % 60 + "s";
		if(this.duration < 60 * 60 * 24)
			return this.duration/3600 + "h" + this.duration/60%60 +"m" + this.duration%60 +"s";
		return this.duration + "s";
	}
	
	//생성자 - 재생시간이 있는 경우와 없는 경우 2가지를 구현
	public Mp3MpFile(String filename, long filesize) {
		super(filename, filesize);
		this.setDuration(0);
//		this(filename, filesize, 0);
	}
	public Mp3MpFile(String filename, long filesize, int duration) {
		super(filename, filesize);
		this.setDuration(duration);
	}
	
	//만약 정보에 재생시간이 포함되었으면 좋겠을 경우 - 재정의를 수행
	@Override
	public void information() {
		super.information(); // 기존의 information;
		System.out.println("재생시간 : " + this.getDurationString());
	}
}
