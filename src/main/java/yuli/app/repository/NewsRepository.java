package yuli.app.repository;

import org.springframework.data.repository.CrudRepository;

import yuli.app.model.News;

public interface NewsRepository extends CrudRepository<News, Integer> {

}
