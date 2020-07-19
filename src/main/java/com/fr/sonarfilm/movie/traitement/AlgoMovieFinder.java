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
		
		
		//round I with first genre in first
		
		List<Movie> results = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreAndFourthGenre(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
		List<Movie> almostPerfect = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreNot(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
//		List<Movie> nearlyPerfect = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreNot(firstAnswer, secondAnswer, fourthAnswer, thirdAnswer);
//		List<Movie> match = movieRepository.findByFirstGenreAndSecondGenreNot(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
		List<Movie> endMatch = movieRepository.findByFirstGenreNotSecond(firstAnswer, secondAnswer);

		//round I with second genre in first
		
		List<Movie> almostPerfectII = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreAndFourthGenre(secondAnswer, firstAnswer,  thirdAnswer, fourthAnswer);
		List<Movie> nearlyPerfectII = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreNot(secondAnswer, firstAnswer, thirdAnswer, fourthAnswer);
//		List<Movie> matchII = movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreNot(secondAnswer, firstAnswer,  fourthAnswer, thirdAnswer);
//		List<Movie> nearlyMatchII = movieRepository.findByFirstGenreAndSecondGenreNot(secondAnswer, firstAnswer, thirdAnswer, fourthAnswer);
		
		//List<Movie> rematchI = movieRepository.findByFirstGenreNot(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
		
		
		if (results.size()<movieLimit) {
			results.addAll(almostPerfect);}
/*		if (results.size()<movieLimit) {results.addAll(nearlyPerfect);}if (results.size()<movieLimit) {
			results.addAll(match);}*/
		if (results.size()<movieLimit) {results.addAll(endMatch);}
		if (results.size()<movieLimit) {
			results.addAll(almostPerfectII);
		}if (results.size()<movieLimit) {
			results.addAll(nearlyPerfectII);
		}/* if (results.size()<movieLimit) {
			results.addAll(matchII);
		}if (results.size()<movieLimit) {
			results.addAll(nearlyMatchII);
		}*/
		
		//List<Movie> noOtherMatch = movieRepository.findByFirstGenre(firstAnswer);
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

	public List<Movie> whichGenreSecond(List<Movie> myMovies, String search){

		myMovies = movieRepository.findBySecondGenre(search);

		return myMovies;


	}

}
