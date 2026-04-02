package kh.dto;

public class MusicDto {
	private int musicID;
	private String musicTitle;
	private String musicArtist;
	private String musicAlbum;
	private String musicRelease;
	private long musicPlay;
	private long musicLike;
	private long musicdislike;
	private String musicGenre;
	private long musicRankPoint;
	
	@Override
	public String toString() {
		return "MusicDto [musicID=" + musicID + ", musicTitle=" + musicTitle + ", musicArtist=" + musicArtist
				+ ", musicAlbum=" + musicAlbum + ", musicRelease=" + musicRelease + ", musicPlay=" + musicPlay
				+ ", musicLike=" + musicLike + ", musicdislike=" + musicdislike + ", musicGenre=" + musicGenre + "]";
	}
	
	public MusicDto() {
		super();
	}

	public long getMusicRankPoint() {
		return musicRankPoint;
	}
	public void setMusicRankPoint(long musicRankPoint) {
		this.musicRankPoint = musicRankPoint;
	}
	public int getMusicID() {
		return musicID;
	}
	public void setMusicID(int musicID) {
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
	public void setMusicPlay(long musicPlay) {
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
