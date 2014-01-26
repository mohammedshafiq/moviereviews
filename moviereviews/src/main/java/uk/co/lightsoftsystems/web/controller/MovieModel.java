package uk.co.lightsoftsystems.web.controller;

import java.util.List;

import uk.co.lightsoftsystems.core.domain.Movie;

public class MovieModel {
	private List<Movie> movies;
	private Movie newMovie;
	
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public Movie getNewMovie() {
		return newMovie;
	}
	public void setNewMovie(Movie newMovie) {
		this.newMovie = newMovie;
	}
	
	
}
