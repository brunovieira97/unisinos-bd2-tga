package model;

import javax.persistence.*;

@Entity
public class Pedido {

	@Id
	private int codigoPedido;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CODIGOCLIENTE", foreignKey = @ForeignKey(name = "FK_CODIGOCLIENTE_PEDIDO"))
	private Cliente codigoCliente;

	public Pedido(Cliente codigoCliente) {
		super();

		this.codigoCliente = codigoCliente;
	}

	public void setCodigoCliente(Cliente codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoPedido() {
		return this.codigoPedido;
	}

	public Cliente getCodigoCliente() {
		return this.codigoCliente;
	}
}