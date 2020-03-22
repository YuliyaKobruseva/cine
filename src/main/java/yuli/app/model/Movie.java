package yuli.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="peliculas")
public class Movie {

	//Para que en form hay valores por defecto tenemos que inicializar variables y crear constructor vacio
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment MySQL
	private int id;
	
	@Column(name="titulo")
	private String title;
	
	@Column(name="duracion")
	private int duration;
	
	@Column(name="clasificacion")
	private String classification;
	
	@Column(name="genero")
	private String genre;
	
	@Column(name="imagen")
	private String img = "cinema.png"; // default img
	
	@Column(name="fechaEstreno")
	private Date datePremiere;
	
	@Column(name="estatus")
	private String status = "Active";
	
	//@Transient //ignora este atributo al realizar conculta
	@OneToOne
	@JoinColumn(name="idDetalle")
	private Detail detail;
	
	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER) //eager - cada vez que consultamos la pelicula nos devuelve horarios
	private List<Timetable> timetables;
	
	
	public Movie() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getDatePremiere() {
		return datePremiere;
	}

	public void setDatePremiere(Date datePremiere) {
		this.datePremiere = datePremiere;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}	

	public List<Timetable> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<Timetable> timetables) {
		this.timetables = timetables;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", classification=");
		builder.append(classification);
		builder.append(", genre=");
		builder.append(genre);
		builder.append(", img=");
		builder.append(img);
		builder.append(", datePremiere=");
		builder.append(datePremiere);
		builder.append(", status=");
		builder.append(status);
		builder.append(", detail=");
		builder.append(detail);
		builder.append(", timetables=");
		builder.append(timetables);
		builder.append("]");
		return builder.toString();
	}

	

	

}
