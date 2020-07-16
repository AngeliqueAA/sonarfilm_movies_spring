package com.fr.sonarfilm.movie.dto;

import org.bson.types.ObjectId;

public class MovieDTO {

	private ObjectId _id;

	  private String title;
	  private String originalTitle;
	  private String actors;
	  private String duration;
	  private String firstGenre;
	  private String fourthGenre;
	  private String realisationYear;
	  private String secondGenre;
	  private String thirdGenre;
	  private String overview;
	  private String imdbId;
	  private String ageLimit;
	  private String director;
	  private String poster;
	  private String writer;
	  private int notation;
	  private Long movieId;
	  
	  
	  
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getFirstGenre() {
		return firstGenre;
	}
	public void setFirstGenre(String firstGenre) {
		this.firstGenre = firstGenre;
	}
	public String getFourthGenre() {
		return fourthGenre;
	}
	public void setFourthGenre(String fourthGenre) {
		this.fourthGenre = fourthGenre;
	}
	public String getRealisationYear() {
		return realisationYear;
	}
	public void setRealisationYear(String realisationYear) {
		this.realisationYear = realisationYear;
	}
	public String getSecondGenre() {
		return secondGenre;
	}
	public void setSecondGenre(String secondGenre) {
		this.secondGenre = secondGenre;
	}
	public String getThirdGenre() {
		return thirdGenre;
	}
	public void setThirdGenre(String thirdGenre) {
		this.thirdGenre = thirdGenre;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(String ageLimit) {
		this.ageLimit = ageLimit;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getNotation() {
		return notation;
	}
	public void setNotation(int notation) {
		this.notation = notation;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	  
	  
	  
	  
	
}
