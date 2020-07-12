package com.fr.sonarfilm.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fr.sonarfilm.movie.models.Movie;
import com.fr.sonarfilm.movie.repositories.MockMovieRepository;
import com.fr.sonarfilm.movie.traitement.AlgoMovieFinder;


@SpringBootTest(classes = MovieApplication.class)
public class MovieAlgoTests {

	
MockMovieRepository mockRepo = new MockMovieRepository();
	
	AlgoMovieFinder algoMovie = new AlgoMovieFinder(mockRepo);
	

	
	
	List<Movie> myMovieList = new ArrayList<Movie>();
	List<Movie> movieList = new ArrayList<Movie>();
	
	  Movie centralIntelligence = new Movie("Central Intelligence", "comedy", "adventure", "action", null);
	  Movie centralIntelligence2 = new Movie("Central Intelligence 2", "comedy", "adventure", "action", null);
	  Movie oneInAMillion = new Movie("One in a million", "comedy", "action", "thriller", "romance");
	  Movie oneInAMillion2 = new Movie("One in a million 2", "comedy", "action", "thriller", "romance");
	  Movie whiteChicks = new Movie("White Chicks", "comedy", "action", "adventure", null);
	  Movie legallyBlond = new Movie("Legally Blonde", "comedy", "action", "adventure", "romance");
	  Movie howHigh = new Movie("How High", "comedy", "crime", null, null);
	  Movie soulPlane = new Movie("Soul Plane", "comedy", "action", null, null);
	  Movie hannahMontana = new Movie("Hannah Montana", "comedy", "family", "romance", null);
	  
	  
	  Movie cats = new Movie("Cats","musical",null, null, null);
	  Movie grease = new Movie("Grease","musical","romance",null, null);
	  
	  Movie insidious = new Movie("Insidious", "horror", "thriller", null, null );
	  Movie insidious2 = new Movie("Insidious 2", "horror", "thriller", "romance", "romance" );
	  Movie frozen = new Movie("Frozen", "animation", "family", "adventure", "musical");
	  Movie frozen2 = new Movie("Frozen 2", "family",  "animation", "adventure", "musical");
	  
	  Movie theHoliday = new Movie("The Holiday", "romance", null, null, null);
	  Movie lotr = new Movie("LOTR", "fantasy", "adventure", "action", null);
	 
      public void addMovies() {
    	  
    	  mockRepo.insert(centralIntelligence);
    	  mockRepo.insert(centralIntelligence2);
    	  mockRepo.insert(oneInAMillion);
    	  mockRepo.insert(whiteChicks);
    	  mockRepo.insert(howHigh);
    	  mockRepo.insert(soulPlane);
    	  mockRepo.insert(insidious);
    	  mockRepo.insert(frozen);
    	  mockRepo.insert(theHoliday);
    	  mockRepo.insert(lotr);
    	  mockRepo.insert(oneInAMillion2);
    	  mockRepo.insert(legallyBlond);
    	  mockRepo.insert(hannahMontana);
    	  mockRepo.insert(insidious2);
    	  mockRepo.insert(grease);
    	  mockRepo.insert(cats);
    	  mockRepo.insert(frozen2);
    	  
    	  
      }
      
      
      
      @Test
    	void shouldReturnGreaseIfMusicalMusicalMusicalMusical() {

    		addMovies();
    		String movie = algoMovie.whichMovie("musical",  "musical", "musical","musical").get(0).getTitle();
    		
    		
    		assertEquals(movie, "Grease");
    		
    	}  
      
    @Test
  	void shouldReturnOneInAMillionIfComedyActionThrillerRomance() {

  		addMovies();
  		String movie = algoMovie.whichMovie("comedy",  "action", "thriller","romance").get(0).getTitle();
  		
  		
  		assertEquals(movie, "One in a million");
  		
  	}
    
   
    @Test
   	void shouldReturnLegallyBlondeIfComedyActionAdventureRomance() {

   		addMovies();
   		String movie = algoMovie.whichMovie("comedy", "action", "adventure","romance").get(0).getTitle();
   		
   		
   		assertEquals(movie, "Legally Blonde");
   		
   	}
    
    
    @Test
   	void shouldReturnWhiteChicksIfComedyActionAdventureRomance() {

   		addMovies();
   		String movie = algoMovie.whichMovie("comedy",  "action", "adventure","crime").get(0).getTitle();
   		
   		
   		assertEquals(movie, "White Chicks");
   		
   	}
    
    

    
    @Test
  	void shouldReturnInsidiousIfHorrorThrillerHorrorThriller() {

  		addMovies();
  		String movie = algoMovie.whichMovie("horror", "thriller", "horror", "thriller").get(0).getTitle();
  		
  		
  		assertEquals(movie, "Insidious");
  		
      
    }
      
   
    @Test
  	void shouldReturnInsidious2IfHorrorThrillerRomanceRomance() {

  		addMovies();
  		String movie = algoMovie.whichMovie("horror", "thriller", "romance", "romance").get(0).getTitle();
  		
  		
  		assertEquals(movie, "Insidious 2");
  		
      
    }
      
      
 
	
	@Test
	void shouldReturnHannahMontanaIfQuestionHorrorFamilyRomanceComedy() {

		addMovies();
		
		addMovies();
  		String movie = algoMovie.whichMovie("comedy", "family", "romance", "comedy").get(0).getTitle();
		
		assertEquals(movie, "Hannah Montana");
		
	}

	
	
	@Test
	void shouldReturnFrozenIfFirstQuestionEqualsAnimation() {
		
		addMovies();
		
		String movie = algoMovie.whichMovie("animation", "romance", "adventure", "musical").get(0).getTitle();
	
		assertEquals(movie, "Frozen");
		
	}

	
	@Test
	void shouldReturnFrozen2IfFirstAnswerAnimationSecondAnswerRomance() {
		
		addMovies();
		
		String movie = algoMovie.whichMovie("animation", "romance", "adventure", "musical").get(1).getTitle();
	
		assertEquals(movie, "Frozen 2");
		
	}
	
	@Test
	void shouldReturnOneIfFirstQuestionEqualsAnimation() {
		
		addMovies();
		
		List<Movie> movie = algoMovie.whichMovie("animation", "romance", "adventure", "musical");
	
		assertEquals(movie.size(), 2);
		
	}
}
