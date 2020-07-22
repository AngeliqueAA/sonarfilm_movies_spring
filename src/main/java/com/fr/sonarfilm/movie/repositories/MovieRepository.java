package com.fr.sonarfilm.movie.repositories;

import java.util.List;

import org.bson.conversions.Bson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fr.sonarfilm.movie.models.Movie;


public interface MovieRepository extends MongoRepository<Movie, String> {
	
	
	/**
	 * 
	 * Automatic query by Spring
	 */
	
	
	
	List<Movie> findByTitle (@Param("title") String title);
	List<Movie> findByFirstGenre(String firstGenre);
	List<Movie> findBySecondGenre(String secondGenre);
	List<Movie> findByFirstGenreAndSecondGenre(@Param("firstGenre") String firstGenre, @Param("secondGenre") String secondGenre);
	List<Movie> findByFirstGenreAndSecondGenreAndThirdGenreAndFourthGenre(String firstGenre, String secondGenre,String thirdGenre, String fourthGenre);
	List<Movie> findByFirstGenreAndSecondGenreAndThirdGenre(String firstGenre, String secondGenre,String thirdGenre);
	Movie findByMovieId(Long movieId);
	
	long count();
	Page<Movie> findAll(Pageable pageable);
	
	/**
	 * 
	 * Personnalised Query
	 */

	@Query("{'firstGenre' : ?0, 'secondGenre': { $ne: ?1 }, 'thirdGenre' :{ $ne: ?2 }, 'fourthGenre' : { $ne: ?3 } }")
	List<Movie> findByFirstGenreNot(@Param("firstGenre") String firstGenre, String secondGenre, String thirdGenre, String fourthGenre);
	
	@Query("{'firstGenre' : ?0, 'secondGenre': { $ne: ?1 } }")
	List<Movie> findByFirstGenreNotSecond(@Param("firstGenre") String firstGenre, String secondGenre);
	
	@Query("{'firstGenre' : { $ne: ?0 }, 'secondGenre': ?1 }")
	List<Movie> findBySecondNotFirst(@Param("firstGenre") String firstGenre, String secondGenre);
	
	@Query("{'firstGenre' : ?0, 'secondGenre' : ?1, 'thirdGenre' :{ $ne: ?2 }, 'fourthGenre' : { $ne: ?3 } }")
	List<Movie> findByFirstGenreAndSecondGenreNot(@Param("firstGenre") String firstGenre, @Param("secondGenre") String secondGenre, String thirdGenre, String fourthGenre);
	
	@Query("{'firstGenre' : ?0, 'secondGenre' : ?1, 'thirdGenre' : ?2, 'fourthGenre' : { $ne: ?3 } }")
	List<Movie> findByFirstGenreAndSecondGenreAndThirdGenreNot(String firstGenre, String secondGenre,
			String thirdGenre, String fourthGenre);
	
	List<Movie> findByDuration(String duration);
	
	

	
	
	

}
