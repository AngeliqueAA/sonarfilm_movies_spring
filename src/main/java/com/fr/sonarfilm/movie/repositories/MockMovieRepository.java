package com.fr.sonarfilm.movie.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fr.sonarfilm.movie.models.Movie;

public class MockMovieRepository implements MovieRepository {

	List<Movie> results = new ArrayList<Movie>();
	
	  
	
	@Override
	public <S extends Movie> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movie> S insert(S entity) {
		results.add(entity);
		return entity;
	}

	@Override
	public <S extends Movie> List<S> insert(Iterable<S> entities) {
		
		return null;
	}

	@Override
	public <S extends Movie> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movie> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Movie> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movie> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Movie> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Movie> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Movie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Movie> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Movie> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movie> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Movie> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Movie> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Movie> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findByFirstGenre(String firstGenre) {
		List<Movie> myMovies = new ArrayList<Movie>();
		
		

		for (Movie m : results ) {
				
				if(firstGenre.equals(m.getFirstGenre())){
					
					myMovies.add(m);
					
				}
			}
			return myMovies;
		
	}

	@Override
	public List<Movie> findByFirstGenreAndSecondGenre(String firstGenre, String secondGenre) {
		List<Movie> myMovies = new ArrayList<Movie>();
		for (Movie m : results ) {
			
			if(firstGenre.equals(m.getFirstGenre()) && secondGenre.equals(m.getSecondGenre())){
				
				myMovies.add(m);
				
			}
		}
		return myMovies;
	}

	@Override
	public List<Movie> findByFirstGenreAndSecondGenreAndThirdGenreAndFourthGenre(String firstGenre, String secondGenre,
			String thirdGenre, String fourthGenre) {
		List<Movie> myMovies = new ArrayList<Movie>();
		for (Movie m : results ) {
			
			if(firstGenre.equals(m.getFirstGenre()) && secondGenre.equals(m.getSecondGenre()) && thirdGenre.equals(m.getThirdGenre()) && fourthGenre.equals(m.getFourthGenre())){
				
				myMovies.add(m);
				
			}
		}
		return myMovies;
	}

	@Override
	public List<Movie> findByFirstGenreAndSecondGenreAndThirdGenre(String firstGenre, String secondGenre,
			String thirdGenre) {
		List<Movie> myMovies = new ArrayList<Movie>();
		for (Movie m : results ) {
			
			if(firstGenre.equals(m.getFirstGenre()) && secondGenre.equals(m.getSecondGenre()) && thirdGenre.equals(m.getThirdGenre())){
				
				myMovies.add(m);
				
			}
		}
		return myMovies;
	}

	@Override
	public List<Movie> findByFirstGenreNot(String firstGenre, String secondGenre, String thirdGenre,
			String fourthGenre) {
		List<Movie> myMovies = new ArrayList<Movie>();
		for (Movie m : results ) {
			
			if(firstGenre.equals(m.getFirstGenre()) && !secondGenre.equals(m.getSecondGenre()) && !thirdGenre.equals(m.getThirdGenre()) && !fourthGenre.equals(m.getFourthGenre())){
				
				myMovies.add(m);
				
			}
		}
		return myMovies;
	}

	@Override
	public List<Movie> findByFirstGenreAndSecondGenreNot(String firstGenre, String secondGenre, String thirdGenre,
			String fourthGenre) {

			List<Movie> myMovies = new ArrayList<Movie>();
			for (Movie m : results ) {
				
				if(firstGenre.equals(m.getFirstGenre()) && secondGenre.equals(m.getSecondGenre()) && !thirdGenre.equals(m.getThirdGenre()) && !fourthGenre.equals(m.getFourthGenre())){
					
					myMovies.add(m);
					
				}
			}
			return myMovies;
	}

	@Override
	public List<Movie> findByFirstGenreAndSecondGenreAndThirdGenreNot(String firstGenre, String secondGenre,
			String thirdGenre, String fourthGenre) {
		List<Movie> myMovies = new ArrayList<Movie>();
		for (Movie m : results ) {
			
			if(firstGenre.equals(m.getFirstGenre()) && secondGenre.equals(m.getSecondGenre()) && thirdGenre.equals(m.getThirdGenre()) && !fourthGenre.equals(m.getFourthGenre())){
				
				myMovies.add(m);
				
			}
		}
		return myMovies;
		
	}

	@Override
	public List<Movie> findBySecondGenre(String secondGenre) {
		List<Movie> myMovies = new ArrayList<Movie>();
		
		

		for (Movie m : results ) {
				
				if(secondGenre.equals(m.getSecondGenre())){
					
					myMovies.add(m);
					
				}
			}
			return myMovies;
		
	}

	

	@Override
	public List<Movie> findBySecondNotFirst(String firstGenre, String secondGenre) {
		List<Movie> myMovies = new ArrayList<Movie>();
		for (Movie m : results ) {
			
			if(!firstGenre.equals(m.getFirstGenre()) && secondGenre.equals(m.getSecondGenre()) ){
				
				myMovies.add(m);
				
			}
		}
		return myMovies;
	}

	@Override
	public List<Movie> findByFirstGenreNotSecond(String firstGenre, String secondGenre) {
		List<Movie> myMovies = new ArrayList<Movie>();
		for (Movie m : results ) {
			
			if(firstGenre.equals(m.getFirstGenre()) && !secondGenre.equals(m.getSecondGenre()) ){
				
				myMovies.add(m);
				
			}
		}
		return myMovies;
	}

	@Override
	public List<Movie> findByMovieId(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findByDuration(String duration) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
