package yuli.app.model;

import java.util.Date;

public class Movie {

	//Para que en form hay valores por defecto tenemos que inicializar variables y crear constructor vacio
	private int id;
	private String title;
	private int duration;
	private String classification;
	private String genre;
	private String img = "cinema.png"; // default img
	private Date datePremiere;
	private String status = "Active";
	private Detail detail;
	
	
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
		builder.append("]");
		return builder.toString();
	}

	

}
