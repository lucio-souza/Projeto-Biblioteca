package model;

public class Cliente {
	private int id;
	private String cpf;
	private String nome;
	private String telefone;
	
	public Cliente(int id, String telefone, String cpf) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
