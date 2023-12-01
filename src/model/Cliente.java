package model;

public class Cliente {
	private int id;
	private String telefone;
	private String cpf;
	
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
	
	
}
