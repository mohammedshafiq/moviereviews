package uk.co.lightsoftsystems.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import uk.co.lightsoftsystems.core.domain.Movie;
import uk.co.lightsoftsystems.core.repository.MovieRepository;

public class MovieService {
	private MovieRepository repository;
	
	@Autowired
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}
	
	public List<Movie> findAllMovies() {
		return repository.findAllMovies();
	}
	
	public void addMovie(Movie movie) {
		repository.save(movie);
	}
}
