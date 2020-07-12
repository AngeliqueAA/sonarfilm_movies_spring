package com.fr.sonarfilm.movie;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fr.sonarfilm.movie.models.Movie;
import com.fr.sonarfilm.movie.repositories.MovieRepository;


@ExtendWith(SpringExtension.class)
@WebMvcTest
class MovieApplicationTests {
	
	private final static String URI = "/apimovies";
	
	//MockMovieRepository mockRepo = new MockMovieRepository();
	

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MovieRepository movieRepo;

	@Test
	public void testGetMovie() throws Exception {

		 Movie jumanji = new Movie("jumanji", "jumanji", "robin williams", "112", "action", "comedy", "1998", "adventure", "drama", "dangerous game", "tt12345", "no", "williames", "na", "na", 7, 9874L);

		List<Movie> movie = Arrays.asList(jumanji);

		given(movieRepo.findByTitle(jumanji.getTitle())).willReturn(movie);

		// Get Department

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/apimovies/{title}", "jumanji")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("[{'title':'jumanji','originalTitle':jumanji,'actors':'robin williams','duration':'112', 'firstGenre':'action'}]"));

	}

	
	

}
