package uk.co.lightsoftsystems.web.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;
import uk.co.lightsoftsystems.core.domain.Movie;
import uk.co.lightsoftsystems.web.services.MovieService;

public class MoviesControllerTest {
	private final String NEW_MOVIE_TITLE = "new movie";
	private final String NEW_MOVIE_DESCRIPTION = "new movie description";
	
	private final String NEW_MOVIE2_TITLE = "new movie2";
	private final String NEW_MOVIE2_DESCRIPTION = "new movie description2";
	
	private MoviesController controller;
	private List<Movie> movies;
	private List<Movie> returnedMovies;
	private ModelAndView findMovies;

	@Mock
	MovieService movieService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.controller =  new MoviesController(this.movieService);
	}
	
	@Test
	public void testFindAllMovies() {
		givenIHave2NewMoviesInStorage();
		whenICallFindAllMovies();
		thenTheMoviesAreRetunedCorrectly();
	}

	private void whenICallFindAllMovies() {
		findMovies = controller.findMovies();
	}
	
	private void thenTheMoviesAreRetunedCorrectly() {
		MovieModel model = (MovieModel)findMovies.getModel().get("moviesModel");
		assertEquals(2, model.getMovies().size()); 
		
		assertEquals(model.getMovies().get(0).getTitle(), NEW_MOVIE_TITLE);
		assertEquals(model.getMovies().get(0).getDescription(), NEW_MOVIE_DESCRIPTION);
		assertEquals(model.getMovies().get(1).getTitle(), NEW_MOVIE2_TITLE);
		assertEquals(model.getMovies().get(1).getDescription(), NEW_MOVIE2_DESCRIPTION);
	}
	
	private void givenIHave2NewMoviesInStorage() {
		Movie m1 = new Movie(NEW_MOVIE_TITLE, NEW_MOVIE_DESCRIPTION);
		Movie m2 = new Movie(NEW_MOVIE2_TITLE, NEW_MOVIE2_DESCRIPTION);
		
		movies = new ArrayList<Movie>();
		movies.add(m1);
		movies.add(m2);
		
		when(movieService.findAllMovies()).thenReturn(movies);
	}

}
