 package com.fr.sonarfilm.movie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.movie.dto.MovieDTO;
import com.fr.sonarfilm.movie.models.Movie;
import com.fr.sonarfilm.movie.repositories.MovieRepository;
import com.fr.sonarfilm.movie.traitement.AlgoMovieFinder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/apimovies")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
/*	private Movie convertToEntity(MovieDTO movieDto) {
		Movie movie = modelMapper.map(movieDto, Movie.class);
		return movie;
	} */
	
	
	private MovieDTO convertToDto(Movie movie) {
		MovieDTO movieDto = new MovieDTO();
		BeanUtils.copyProperties(movie, movieDto);
		return movieDto;
	}
	
	
	@GetMapping(value = "/")
	public List<MovieDTO> getAllMovies() {
		 List<Movie> movies = movieRepository.findAll();
		 return movies
				  .stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}
	
	@GetMapping(value = "/title/{title}")
	public List<MovieDTO> getMovieByTitle(@PathVariable("title") String title) {
	  List<Movie> movies = movieRepository.findByTitle(title);
	  return movies
			  .stream()
	          .map(this::convertToDto)
	          .collect(Collectors.toList());
			  
	}
	
	@GetMapping(value = "/quizz/{firstGenre}")
	public List<MovieDTO> getMovieByFirstGenre(@PathVariable("firstGenre") String firstGenre) {
		List<Movie> movies = movieRepository.findByFirstGenre(firstGenre);
		return movies
				  .stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}
	
	

	@GetMapping(value = "/quizz/{firstAnswer}/{secondAnswer}/{thirdAnswer}/{fourthAnswer}")
	public List<MovieDTO> processQuizz(@PathVariable("firstAnswer") String firstAnswer, @PathVariable("secondAnswer") String secondAnswer, @PathVariable("thirdAnswer") String thirdAnswer, @PathVariable("fourthAnswer") String fourthAnswer) {
		List <Movie> quizzResults = new AlgoMovieFinder(movieRepository).whichMovie(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
		List <Movie> movies =  quizzResults.subList(0, 21);
		return movies
				  .stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}
	
}
