package uk.co.lightsoftsystems.adapters;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import uk.co.lightsoftsystems.core.domain.Movie;
import uk.co.lightsoftsystems.core.repository.MovieRepository;

public class InMemoryListMovieRepositoryTest {
	private final String NEW_MOVIE_TITLE = "new movie";
	private final String NEW_MOVIE_DESCRIPTION = "new movie description";
	
	private final String NEW_MOVIE2_TITLE = "new movie2";
	private final String NEW_MOVIE2_DESCRIPTION = "new movie description2";

	@Mock
	private MovieRepository movieRepository;
	
	private Movie movie;
	private Movie savedMovie;
	private List<Movie> movies;
	
	@Before
	public void setup() {
		movieRepository = new InMemoryListMovieRepository();
	}
	
	@Test
	public void whenISaveAMovieThenItIsSaved() {
		givenIHaveANewMovie();
		whenISaveTheMovie();
		thenMovieHasTheCorrectDetails();
	}

	@Test
	public void whenIFindAllMoviesThenAllMoviesAreReturned() {
		giveIClearTheMovieStorage();
		givenIAdd2NewMovies();
		whenIFindAllMovies();
		thenAllTheMoviesAreReturned();
	}

	private void givenIHaveANewMovie() {
		movie = new Movie();
		movie.setTitle(NEW_MOVIE_TITLE);
		movie.setDescription(NEW_MOVIE_DESCRIPTION);
	}
	
	private void whenISaveTheMovie() {
		savedMovie = movieRepository.save(movie);
	}

	private void thenMovieHasTheCorrectDetails() {
		assertEquals(NEW_MOVIE_TITLE, savedMovie.getTitle());
		assertEquals(NEW_MOVIE_DESCRIPTION, savedMovie.getDescription());
	}

	private void whenIFindAllMovies() {
		movies = movieRepository.findAllMovies();
	}
	
	
	private void givenIAdd2NewMovies() {
		Movie m1 = new Movie(NEW_MOVIE_TITLE, NEW_MOVIE_DESCRIPTION);
		Movie m2 = new Movie(NEW_MOVIE2_TITLE, NEW_MOVIE2_DESCRIPTION);
		
		movieRepository.save(m1);
		movieRepository.save(m2);
	}

	private void giveIClearTheMovieStorage() {
		movieRepository.clearAllMovies();
	}

	public void thenAllTheMoviesAreReturned() {
		assertEquals(2, movies.size());
		assertEquals(movies.get(0).getTitle(), NEW_MOVIE_TITLE);
		assertEquals(movies.get(0).getDescription(), NEW_MOVIE_DESCRIPTION);
		assertEquals(movies.get(1).getTitle(), NEW_MOVIE2_TITLE);
		assertEquals(movies.get(1).getDescription(), NEW_MOVIE2_DESCRIPTION);
	}
}
