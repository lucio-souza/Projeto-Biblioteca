package model;

public class Livro {
	private int id;
	private String titulo;
	private String genero;
	private String dtPubli;
	
	public Livro(int id, String titulo, String genero, String dtPubli) {
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
	public String getDtPubli() {
		return dtPubli;
	}
	public void setDtPubli(String dtPubli) {
		this.dtPubli = dtPubli;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
