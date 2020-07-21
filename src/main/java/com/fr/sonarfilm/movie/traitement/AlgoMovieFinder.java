package com.fr.sonarfilm.movie.traitement;

import java.util.ArrayList;
import java.util.List;

import com.fr.sonarfilm.movie.models.Movie;
import com.fr.sonarfilm.movie.repositories.MovieRepository;

public class AlgoMovieFinder {


	private MovieRepository movieRepository;


	public AlgoMovieFinder(MovieRepository repository) {
		movieRepository=repository;
		// TODO Auto-generated constructor stub
	}

		public List<Movie> whichMovie(String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer) {
		int movieLimit = 20;

		List<Movie> results = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreAndFourthGenre(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
		
		List<Movie> almostPerfect = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreNot(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
		List<Movie> endMatch = movieRepository.findByFirstGenreNotSecond(firstAnswer, secondAnswer);


		
		List<Movie> almostPerfectII = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreAndFourthGenre(secondAnswer, firstAnswer,  thirdAnswer, fourthAnswer);
		List<Movie> nearlyPerfectII = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreNot(secondAnswer, firstAnswer, thirdAnswer, fourthAnswer);

		
		
		if (results.size()<movieLimit) {
			results.addAll(almostPerfect);}
		if (results.size()<movieLimit) {results.addAll(endMatch);}
		if (results.size()<movieLimit) {
			results.addAll(almostPerfectII);
		}if (results.size()<movieLimit) {
			results.addAll(nearlyPerfectII);
		}
		
		List<Movie> noOtherMatch = movieRepository.findBySecondNotFirst(secondAnswer, firstAnswer);
		
		if(results.size()<movieLimit) {
			for(Movie m : noOtherMatch) {
				results.add(m);
			}
		}
		
		if(results.isEmpty()) {
			results.addAll(movieRepository.findByFirstGenre(firstAnswer));
			} 
		
		return results;
		
		}
		
		
		
		public List<Movie> getSimilarMovie(Long movieId){
			
		Movie movie = movieRepository.findByMovieId(movieId);
			
		
		List<Movie> movies = whichMovie(movie.getFirstGenre(), movie.getSecondGenre(), movie.getThirdGenre(), movie.getFourthGenre());
		List<Movie> similarMovies = new ArrayList<Movie>(); 
		
		for(Movie m : movies) {
			if(!m.getMovieId().equals(movie.getMovieId())) {
				similarMovies.add(m);
			}
			
		}
		return similarMovies;
		
	
		
		
		}



}
