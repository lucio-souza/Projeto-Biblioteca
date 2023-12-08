package model;

public class Bibliotecario {
	private int id;
	private String email;
	private int senha;
	
	public Bibliotecario(String email,int senha) {
		super();
		this.email=email;
		this.senha=senha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Bibliotecario [id=" + id + ", email=" + email + ", senha=" + senha + "]";
	}
	
}
