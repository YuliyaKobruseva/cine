package yuli.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="noticias")
public class News {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //depende de la bbdd, para Oracle es sequence
	private int id;
	
	/*
	 * name: Permite establecer el nombre del campo de la tabla de la base de datos
	 * 		que mapeará el atributo donde se aplique la anotación @Column. A pesar de que
	 * 		ningún atributo de @Column es obligatorio, este atributo siempre recomiendo
	 * 		establecerlo. 
	 * length: Permite definir la longitud de la columna en
	 * 			caracteres, solo aplica para Strings. 
	 * nullable: Crea una restricción en la
	 * 			tabla (Not Null) para impedir que se inserten valores nulos.
	 * 
	 * Si nombre de las columnas es identico a la bbdd se puede omitir la anotacion @Column, pero es mejor siempre incluirla
	 */
	
	
	@Column(name="titulo", length = 250, nullable = false)
	private String title;
	
	@Column(name="detalle")
	private String detail;
	
	@Column(name="fecha")
	private Date date;
	
	@Column(name="estatus", nullable = false)
	private String status;

	public News() {
		this.date= new Date();
		this.status="Active";
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", detail=" + detail + ", date=" + date + ", status=" + status
				+ "]";
	}

}
