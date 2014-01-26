package uk.co.lightsoftsystems.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import uk.co.lightsoftsystems.core.domain.Movie;
import uk.co.lightsoftsystems.core.repository.MovieRepository;

public class MovieRepositoryTest {
	private final String NEW_MOVIE_TITLE = "new movie";
	private final String NEW_MOVIE_DESCRIPTION = "new movie description";
	
	@Mock
	private MovieRepository movieRepository;
	
	private Movie movie;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void whenISaveAMovieThenItIsStored() {
		givenIHaveANewMovie();
	}
	
	public void givenIHaveANewMovie() {
		movie = new Movie();
		movie.setTitle(NEW_MOVIE_TITLE);
		movie.setDescription(NEW_MOVIE_DESCRIPTION);
	}
	
}
