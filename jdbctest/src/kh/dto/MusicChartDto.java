package kh.dto;

public class MusicChartDto {
	private long musicID;
	private String musicTitle;
	private String musicArtist;
	private String musicAlbum;
	private String musicRelease;
	private Long musicPlay; //null 가능 여부를 항상 주의하기
	private long musicLike;
	private long musicdislike;
	private String musicGenre;
	private long musicPoint; //뷰에서 추가한 항목
	
	
	@Override
	public String toString() {
		return "MusicCahrtDto [musicID=" + musicID + ", musicTitle=" + musicTitle + ", musicArtist=" + musicArtist
				+ ", musicAlbum=" + musicAlbum + ", musicRelease=" + musicRelease + ", musicPlay=" + musicPlay
				+ ", musicLike=" + musicLike + ", musicdislike=" + musicdislike + ", musicGenre=" + musicGenre
				+ ", musicPoint=" + musicPoint + ", getMusicPoint()=" + getMusicPoint() + "]";
	}
	public MusicChartDto() {
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
	public Long getMusicPlay() {
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
	public long getMusicPoint() {
		return musicPoint;
	}
	public void setMusicPoint(long musicPoint) {
		this.musicPoint = musicPoint;
	}
	
}
