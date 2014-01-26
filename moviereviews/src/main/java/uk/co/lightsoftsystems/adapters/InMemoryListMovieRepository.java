package uk.co.lightsoftsystems.adapters;

import java.util.ArrayList;
import java.util.List;

import uk.co.lightsoftsystems.core.domain.Movie;
import uk.co.lightsoftsystems.core.repository.MovieRepository;

public class InMemoryListMovieRepository implements MovieRepository {
	private List<Movie> movies = new ArrayList<Movie>();
	
	
	public InMemoryListMovieRepository() {
		movies.add(new Movie("Shawshank Redemption", "Did this movie get an oscar?"));
		movies.add(new Movie("Star Wars", "Luke, I am your father"));
	}
	
	@Override
	public Movie findMovie(int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie save(Movie movie) {
		movies.add(movie);
		
		return movie;
	}

	@Override
	public List<Movie> findAllMovies() {
		return movies;
	}
	
	@Override
	public void clearAllMovies() {
		movies = new ArrayList<Movie>();
	}

}
