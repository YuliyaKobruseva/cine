package yuli.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import yuli.app.model.Movie;
import yuli.app.model.Timetable;
import yuli.app.service.IBannersService;
import yuli.app.service.IMoviesService;
import yuli.app.service.ITimetableService;
import yuli.app.tools.ToolsApp;

@Controller
public class HomeController {

	@Autowired
	private IBannersService bs;
	@Autowired
	private IMoviesService ms;
	@Autowired
	private ITimetableService ts;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
//		nombre de archivo .jsp de la vista
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchMoviesDate(@RequestParam("fecha") String date, Model model) {
		List<String> listDates = ToolsApp.getNextDay(4);
		List<Movie> movies = ms.searchAll();
		model.addAttribute("dates", listDates);
		model.addAttribute("dateSearch", date);
		model.addAttribute("movies", movies);
		return "home";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showPrincipal(Model model) {

		List<String> listDates = ToolsApp.getNextDay(4);
		List<Movie> movies = ms.searchAll();
		model.addAttribute("dates", listDates);
		model.addAttribute("dateSearch", dateFormat.format(new Date()));
		model.addAttribute("movies", movies);
		return "home";
	}

	@RequestMapping(value = "/detail/{id}/{date}",method=RequestMethod.GET)		
	public String showDetail(Model model,@PathVariable("id") int idMovie, @PathVariable("date") Date date) {
					
		List <Timetable> timetables = ts.searchByIdMovie(idMovie, date);
		model.addAttribute("timetables", timetables);
		model.addAttribute("dateSearch", dateFormat.format(date));
		model.addAttribute("movie", ms.searchById(idMovie));
		
		return "detail";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
