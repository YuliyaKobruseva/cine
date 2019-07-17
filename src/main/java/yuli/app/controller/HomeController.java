package yuli.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import yuli.app.model.Movie;
import yuli.app.tools.ToolsApp;

@Controller
public class HomeController {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
//		nombre de archivo .jsp de la vista
		return "home";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String searchMoviesDate(@RequestParam("fecha") String date, Model model) {
		List<String>listDates=ToolsApp.getNextDay(4);
		List<Movie> movies = getMovies();
		model.addAttribute("dates",listDates);
		model.addAttribute("dateSearch", date);
		model.addAttribute("movies", movies);
		return "home";
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showPrincipal(Model model) {

		List<String>listDates=ToolsApp.getNextDay(4);
		List<Movie> movies = getMovies();
		model.addAttribute("dates",listDates);
		model.addAttribute("dateSearch", dateFormat.format(new Date()));
		model.addAttribute("movies", movies);
		return "home";
	}

//	@RequestMapping(value = "/detail/{id}/{date}", method = RequestMethod.GET)
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	public String showDetail(Model model, @PathVariable("id") int idMovie, @PathVariable("date") String date) {
	public String showDetail(Model model, @RequestParam("idMovie") int idMovie, @RequestParam("date") String date) {

		System.out.println(idMovie+" "+date);
//		String title = "Fast and Furious";
//		int duration = 139;
//		double price = 12.45;
//		model.addAttribute("title", title);
//		model.addAttribute("duration", duration);
//		model.addAttribute("price", price);

		return "detail";
	}

	private List<Movie> getMovies() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Movie> listMovies = null;
		try {
			listMovies = new LinkedList<>();

			Movie movie1 = new Movie();
			movie1.setId(1);
			movie1.setTitle("Power Rangers");
			movie1.setDuration(120);
			movie1.setClassification("B");
			movie1.setGenre("Aventura");
			movie1.setDatePremiere(formatter.parse("02-05-2017"));

			Movie movie2 = new Movie();
			movie2.setId(2);
			movie2.setTitle("La bella y la bestia");
			movie2.setDuration(132);
			movie2.setClassification("A");
			movie2.setGenre("Infantil");
			movie2.setDatePremiere(formatter.parse("20-05-2017"));
			movie2.setImg("bella.png");

			Movie movie3 = new Movie();
			movie3.setId(3);
			movie3.setTitle("Contratiempo");
			movie3.setDuration(106);
			movie3.setClassification("B");
			movie3.setGenre("Thriller");
			movie3.setDatePremiere(formatter.parse("28-05-2017"));
			movie3.setImg("contratiempo.png");

			Movie movie4 = new Movie();
			movie4.setId(4);
			movie4.setTitle("Kong La Isla Calavera");
			movie4.setDuration(118);
			movie4.setClassification("B");
			movie4.setGenre("Accion y Aventura");
			movie4.setDatePremiere(formatter.parse("06-06-2017"));
			movie4.setImg("kong.png");
			movie4.setStatus("Inactive");
			
			Movie movie5 = new Movie();
			movie5.setId(5);
			movie5.setTitle("Life: Vida Inteligente");
			movie5.setDuration(104);
			movie5.setClassification("B");
			movie5.setGenre("Drama");
			movie5.setDatePremiere(formatter.parse("10-06-2017"));
			movie5.setImg("estreno5.png"); // Nombre del archivo de imagen
			movie5.setStatus("Active"); // Esta pelicula estara inactiva

			listMovies.add(movie1);
			listMovies.add(movie2);
			listMovies.add(movie3);
			listMovies.add(movie4);
			listMovies.add(movie5);

			return listMovies;
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
}
