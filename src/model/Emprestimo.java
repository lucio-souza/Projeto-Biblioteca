package model;
import java.time.LocalDate;

public class Emprestimo {
	private int id;
	private int idCliente;
	private int idLivro;
	private LocalDate dtReserva;
	private LocalDate dtEntrega;

	public Emprestimo(int idCliente, int idLivro, LocalDate dtReserva) {
		super();
		this.idCliente = idCliente;
		this.idLivro = idLivro;
		this.dtReserva= dtReserva;
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

	public LocalDate getDtentrega() {
		return dtEntrega;
	}

	public void setDtEntrega(LocalDate dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", idCliente=" + idCliente + ", idLivro=" + idLivro + ", dtReserva=" + dtReserva
				+ ", dtEntrega=" + dtEntrega + "]";
	}
	
	
}
