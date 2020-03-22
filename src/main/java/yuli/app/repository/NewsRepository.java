package yuli.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yuli.app.model.News;

@Repository
//public interface NewsRepository extends CrudRepository<News, Integer>
public interface NewsRepository extends JpaRepository<News, Integer> {
	
	List<News> findByStatus(String status);
	
	List<News> findByDate(Date date);
	
	List <News> findByStatusAndDate(String status, Date date);
	
	List <News> findByStatusOrDate(String status, Date date);
	
	List <News> findByDateBetween(Date date1, Date date2);
	
	List <News> findByIdBetween(int id1, int id2);

}
