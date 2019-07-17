package yuli.app.model;

import java.util.Date;

public class Movie {

	private int id;
	private String title;
	private int duration;
	private String classification;
	private String genre;
	private String img = "cinema.png"; // default img
	private Date datePremiere;
	private String status = "Active";

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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", duration=" + duration + ", classification=" + classification
				+ ", genre=" + genre + ", img=" + img + ", datePremiere=" + datePremiere + ", status=" + status + "]";
	}

}
