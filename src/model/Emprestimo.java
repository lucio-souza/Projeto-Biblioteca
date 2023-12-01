package model;
import java.time.LocalDate;

public class Emprestimo {
	private int idCliente;
	private int idLivro;
	private LocalDate dtPubli;
	
	public Emprestimo(int idCliente, int idLivro, LocalDate dtPubli) {
		super();
		this.idCliente = idCliente;
		this.idLivro = idLivro;
		this.dtPubli = dtPubli;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public LocalDate getDtPubli() {
		return dtPubli;
	}

	public void setDtPubli(LocalDate dtPubli) {
		this.dtPubli = dtPubli;
	}
}
