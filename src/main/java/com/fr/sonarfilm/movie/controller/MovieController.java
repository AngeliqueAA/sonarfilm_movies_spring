 package com.fr.sonarfilm.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.movie.models.Movie;
import com.fr.sonarfilm.movie.repositories.MovieRepository;
import com.fr.sonarfilm.movie.traitement.AlgoMovieFinder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/apimovies")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;

	
	@GetMapping(value = "/")
	public List<Movie> getAllMovies() {
	  return movieRepository.findAll();
	}
	
	@GetMapping(value = "/{title}")
	public List<Movie> getMovieByTitle(@PathVariable("title") String title) {
	  return movieRepository.findByTitle(title);
	}
	
	@GetMapping(value = "/quizz/{firstGenre}")
	public List<Movie> getMovieByFirstGenre(@PathVariable("firstGenre") String firstGenre) {
	  return movieRepository.findByFirstGenre(firstGenre);
	}
	
	
	/*@GetMapping(value = "/quizz/{firstGenre}/{secondGenre}/{thirdGenre}/{fourthGenre}")
	public List<Movie> getMovieByFirstGenreAndSecondGenre(@PathVariable("firstGenre") String firstGenre, @PathVariable("secondGenre") String secondGenre, @PathVariable("thirdGenre") String thirdGenre, @PathVariable("fourthGenre") String fourthGenre ) {
	  return movieRepository.findByFirstGenreAndSecondGenreAndThirdGenreAndFourthGenre(firstGenre, secondGenre, thirdGenre, fourthGenre);
	}
	*/
	
	
	
	//requestbody ici et pas pathvariable
	@GetMapping(value = "/quizz/{firstAnswer}/{secondAnswer}/{thirdAnswer}/{fourthAnswer}")
	public List<Movie> processQuizz(@PathVariable("firstAnswer") String firstAnswer, @PathVariable("secondAnswer") String secondAnswer, @PathVariable("thirdAnswer") String thirdAnswer, @PathVariable("fourthAnswer") String fourthAnswer) {
		return new AlgoMovieFinder(movieRepository).whichMovie(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
	}
	
}
