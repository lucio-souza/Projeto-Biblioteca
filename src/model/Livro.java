package model;

import java.time.LocalDate;

public class Livro {
	private int id;
	private String titulo;
	private String genero;
	private LocalDate dtPubli;
	
	public Livro(int id, String titulo, String genero, LocalDate dtPubli) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.dtPubli = dtPubli;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public LocalDate getDtPubli() {
		return dtPubli;
	}
	public void setDtPubli(LocalDate dtPubli) {
		this.dtPubli = dtPubli;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
