package uk.co.lightsoftsystems.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.co.lightsoftsystems.core.domain.Movie;
import uk.co.lightsoftsystems.web.services.MovieService;

@Controller
@RequestMapping("/movies")
public class MoviesController {
	private MovieService movieService;

	@Autowired
	public MoviesController(MovieService movieService) {
		this.movieService = movieService;
	}

	@RequestMapping(method = {RequestMethod.GET})
	public ModelAndView findMovies() {
		List<Movie> movies = movieService.findAllMovies();

		MovieModel model = new MovieModel();
		model.setMovies(movies);

		return new ModelAndView("viewMovies", "moviesModel", model);
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	public ModelAndView addMovie(@ModelAttribute MovieModel model) {
		movieService.addMovie(model.getNewMovie());
		
		List<Movie> movies = movieService.findAllMovies();
		model.setMovies(movies);
		
		return new ModelAndView("viewMovies", "moviesModel", model);
	}

	@RequestMapping("/view")
	public ModelAndView view() {
		ModelMap model = new ModelMap();

		return new ModelAndView("viewMovies", "moviesModel", model);
	}
}
