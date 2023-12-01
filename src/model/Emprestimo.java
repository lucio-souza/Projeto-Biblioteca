package model;
import java.time.LocalDate;

public class Emprestimo {
	private int idCliente;
	private int idLivro;
	private LocalDate dtemprestimo;
	private LocalDate dtDevolucao;

	public Emprestimo(int idCliente, int idLivro, LocalDate dtemprestimo, LocalDate dtDevolucao) {
		super();
		this.idCliente = idCliente;
		this.idLivro = idLivro;
		this.dtemprestimo = dtemprestimo;
		this.dtDevolucao = dtDevolucao;
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

	public LocalDate getDtemprestimo() {
		return dtemprestimo;
	}

	public void setDtemprestimo(LocalDate dtemprestimo) {
		this.dtemprestimo = dtemprestimo;
	}

	public LocalDate getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(LocalDate dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}
}
