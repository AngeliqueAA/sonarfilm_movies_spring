 package com.fr.sonarfilm.movie.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	
	@GetMapping(value = "/lucky")
	public MovieDTO getMovieBeingLucky() {
		long qty = movieRepository.count();
		int idx = (int)(Math.random()*qty);
		
		Page<Movie> moviePage = movieRepository.findAll(PageRequest.of(idx, 1, Sort.unsorted()));
		Movie movie = null;
		
		if(moviePage.hasContent()) {
			movie = moviePage.getContent().get(0);		
					}
		return convertToDto(movie);
		
	/*	List<MovieDTO> movies = getAllMovies();
		Random rand = new Random();
		MovieDTO randomMovie = movies.get(rand.nextInt(movies.size()));
		return randomMovie; 
		*/

	}
	
	@GetMapping(value = "/title/{title}")
	public List<MovieDTO> getMovieByTitle(@PathVariable("title") String title) {
	  List<Movie> movies = movieRepository.findByTitle(title);
	  return movies
			  .stream()
	          .map(this::convertToDto)
	          .collect(Collectors.toList());
			  
	}
	
	@GetMapping(value = "/search/first/{firstGenre}")
	public List<MovieDTO> getMovieByFirstGenre(@PathVariable("firstGenre") String firstGenre) {
		List<Movie> movies = movieRepository.findByFirstGenre(firstGenre);
		return movies
				  .stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}
	
	
	@GetMapping(value = "/search/second/{secondGenre}")
	public List<MovieDTO> getMovieBySecondGenre(@PathVariable("secondGenre") String secondGenre) {
		List<Movie> movies = movieRepository.findBySecondGenre(secondGenre);
		return movies
				  .stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}
	
 
	@GetMapping(value = "/search/movieId/{movieId}")
	public MovieDTO getMovieByMovieId(@PathVariable("movieId") Long movieId) {
		return convertToDto(movieRepository.findByMovieId(movieId));
		
	}
	

	
	
	@GetMapping(value = "/search/duration/{duration}")
	public List<MovieDTO> getMovieByDuration(@PathVariable("duration") String duration) {
		List<Movie> movies = movieRepository.findByDuration(duration);
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
	
	@GetMapping(value = "/quizz/{movieId}")
	public List<MovieDTO> getSimilarMovie(@PathVariable("movieId") Long movieId) {
		List <Movie> quizzResults = new AlgoMovieFinder(movieRepository).getSimilarMovie(movieId);
		List <Movie> movies =  quizzResults.subList(0, 21);
		return movies
				  .stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}
	
	
	
}
