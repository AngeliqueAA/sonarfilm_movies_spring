package com.fr.sonarfilm.movie.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Movie {
	
	@Id 
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
	  
	
	  public Movie() {
		// TODO Auto-generated constructor stub
	}

	  
	  public Movie(String title, String firstGenre, String secondGenre, String thirdGenre,
				String fourthGenre) {		
			this.title = title;
			this.firstGenre = firstGenre;
			this.secondGenre = secondGenre;
			this.thirdGenre = thirdGenre;
			this.fourthGenre = fourthGenre;
			
		}
	  
	  

	public Movie(String title, String originalTitle, String actors, String duration, String firstGenre,
			String fourthGenre, String realisationYear, String secondGenre, String thirdGenre, String overview,
			String imdbId, String ageLimit, String director, String poster, String writer, int notation, Long movieId) {
		
		this.title = title;
		this.originalTitle = originalTitle;
		this.actors = actors;
		this.duration = duration;
		this.firstGenre = firstGenre;
		this.fourthGenre = fourthGenre;
		this.realisationYear = realisationYear;
		this.secondGenre = secondGenre;
		this.thirdGenre = thirdGenre;
		this.overview = overview;
		this.imdbId = imdbId;
		this.ageLimit = ageLimit;
		this.director = director;
		this.poster = poster;
		this.writer = writer;
		this.notation = notation;
		this.movieId = movieId;
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
