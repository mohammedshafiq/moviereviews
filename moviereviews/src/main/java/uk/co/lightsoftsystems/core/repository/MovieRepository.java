package uk.co.lightsoftsystems.core.repository;

import java.util.List;

import uk.co.lightsoftsystems.core.domain.Movie;


public interface MovieRepository {

	public List<Movie> findAllMovies();

	public Movie findMovie(int movieId);
	
	public Movie save(Movie movie);
	
	public void clearAllMovies();

}
