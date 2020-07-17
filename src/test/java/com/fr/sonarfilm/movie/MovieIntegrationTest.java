package com.fr.sonarfilm.movie;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fr.sonarfilm.movie.models.Movie;
import com.fr.sonarfilm.movie.repositories.MovieRepository;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class MovieIntegrationTest {
	
	private final static String URI = "/apimovies";

	
	private MockMvc mockMvc;

	@MockBean
	private MovieRepository movieRepo;
	
	@Autowired
	private WebApplicationContext wac;


	@BeforeAll
	public void setup() {

	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

	}

	@Test
	public void GetMovieShouldReturnOk() throws Exception {

		 Movie jumanji = new Movie("jumanji", "jumanji", "robin williams", "112", "action", "comedy", "1998", "adventure", "drama", "dangerous game", "tt12345", "no", "williams", "na", "na", 7, 9874L);

		List<Movie> movie = Arrays.asList(jumanji);

		given(movieRepo.findByTitle(jumanji.getTitle())).willReturn(movie);


		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/apimovies/title/{title}", "jumanji")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("[{'title':'jumanji','originalTitle':jumanji,'actors':'robin williams','duration':'112', 'firstGenre':'action'}]"));

	}
	
	
	@Test
	public void GetAllMovieShouldReturnOk() throws Exception {

		 Movie jumanji = new Movie("jumanji", "jumanji", "robin williams", "112", "action", "comedy", "1998", "adventure", "drama", "dangerous game", "tt12345", "no", "williams", "na", "na", 7, 9874L);

		List<Movie> movie = Arrays.asList(jumanji);

		given(movieRepo.findAll()).willReturn(movie);


		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/apimovies/")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("[{'title':'jumanji','originalTitle':jumanji,'actors':'robin williams','duration':'112', 'firstGenre':'action'}]"));

	}
	
	@Test
	public void WrongPathShouldReturnERRORCLIENT() throws Exception {

		 Movie jumanji = new Movie("jumanji", "jumanji", "robin williams", "112", "action", "comedy", "1998", "adventure", "drama", "dangerous game", "tt12345", "no", "williams", "na", "na", 7, 9874L);

		List<Movie> movie = Arrays.asList(jumanji);

		given(movieRepo.findByTitle(jumanji.getTitle())).willReturn(movie);


		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/wrongpath/")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());;

	}
	
}
