package yuli.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yuli.app.model.News;
import yuli.app.service.INewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private INewsService serviceNews;

	@GetMapping(value = "/create")
	public String create() {
		return "news/newsForm";
	}

	//Use Data Binding for save object
	@PostMapping(value = "/save")
	public String save(News news) {

		serviceNews.saveNews(news);
		return "news/newsForm";
	}
}
