package model;

import java.util.Date;

public class Livro {
	private int id;
	private String titulo;
	private Date dtPubli;
	private String genero;
	private String status;
	private String autor;
	
	public Livro(String titulo, Date dtPubli, String genero, String autor) {
		super();
		this.titulo = titulo;
		this.dtPubli = dtPubli;
		this.genero = genero;
		this.autor = autor;
	}
	public Livro() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getDtPubli() {
		return dtPubli;
	}
	public void setDtPubli(Date dtPubli) {
		this.dtPubli = dtPubli;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
