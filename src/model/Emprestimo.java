package model;
import java.time.LocalDate;

public class Emprestimo {
	private int id;
	private int idCliente;
	private int idLivro;
	private LocalDate dtReserva;
	private LocalDate dtEntrega;

	public Emprestimo(int idCliente, int idLivro, LocalDate dtReserva, LocalDate dtEntrega) {
		super();
		this.idCliente = idCliente;
		this.idLivro = idLivro;
		this.dtReserva= dtReserva;
		this.dtEntrega=dtEntrega;
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

	public LocalDate getDtReserva() {
		return dtReserva;
	}

	public void setDtReserva(LocalDate dtReserva) {
		this.dtReserva = dtReserva;
	}

	public LocalDate getDtDevolucao() {
		return dtEntrega;
	}

	public void setDtDevolucao(LocalDate dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
