package kh.dto;

public class MusicDto {
	private long musicID;
	private String musicTitle;
	private String musicArtist;
	private String musicAlbum;
	private String musicRelease;
	private Long musicPlay; //null 가능 여부를 항상 주의하기
	private long musicLike;
	private long musicdislike;
	private String musicGenre;
	
	@Override
	public String toString() {
		return "MusicDto [musicID=" + musicID + ", musicTitle=" + musicTitle + ", musicArtist=" + musicArtist
				+ ", musicAlbum=" + musicAlbum + ", musicRelease=" + musicRelease + ", musicPlay=" + musicPlay
				+ ", musicLike=" + musicLike + ", musicdislike=" + musicdislike + ", musicGenre=" + musicGenre
				+ ", getPoint()=" + getPoint() + "]";
	}

	//가상의 getter
	public long getPoint() {
		return musicPlay * 2 + musicLike * 5 - musicdislike * 10;
	}
	
	public MusicDto() {
		super();
	}

	public long getMusicID() {
		return musicID;
	}
	public void setMusicID(long musicID) {
		this.musicID = musicID;
	}
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getMusicArtist() {
		return musicArtist;
	}
	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}
	public String getMusicAlbum() {
		return musicAlbum;
	}
	public void setMusicAlbum(String musicAlbum) {
		this.musicAlbum = musicAlbum;
	}
	public String getMusicRelease() {
		return musicRelease;
	}
	public void setMusicRelease(String musicRelease) {
		this.musicRelease = musicRelease;
	}
	public long getMusicPlay() {
		return musicPlay;
	}
	public void setMusicPlay(Long musicPlay) {
		this.musicPlay = musicPlay;
	}
	public long getMusicLike() {
		return musicLike;
	}
	public void setMusicLike(long musicLike) {
		this.musicLike = musicLike;
	}
	public long getMusicdislike() {
		return musicdislike;
	}
	public void setMusicdislike(long musicdislike) {
		this.musicdislike = musicdislike;
	}
	public String getMusicGenre() {
		return musicGenre;
	}
	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}
}
