package model;

import java.time.LocalDate;

public class Livro {
	private int id;
	private String titulo;
	private LocalDate dtPubli;
	private String genero;
	private String status;
	private String autor;
	
	public Livro(String titulo, LocalDate dtPubli, String genero, String autor,String status) {
		super();
		this.titulo = titulo;
		this.dtPubli = dtPubli;
		this.genero = genero;
		this.autor = autor;
		this.status=status;
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
	
	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", dtPubli=" + dtPubli + ", genero=" + genero + ", status="
				+ status + ", autor=" + autor + "]";
	}
}
