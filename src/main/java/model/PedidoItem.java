package model;

import javax.persistence.*;

@Entity
public class PedidoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedidoitem")
	@SequenceGenerator(name = "seq_pedidoitem", sequenceName = "s_pedidoitem", allocationSize = 1)
	@Column(name = "codigopedidoitem", nullable = false)
	private int codigo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "codigopedido", foreignKey = @ForeignKey(name = "fk_pedidoitem_pedido"))
	private Pedido pedido;

	@ManyToOne(optional = false)
	@JoinColumn(name = "codigoproduto", foreignKey = @ForeignKey(name = "fk_pedidoitem_produto"))
	private Produto produto;

	@Column(name = "quantidade", nullable = false)
	private int quantidade;

	@Column(name = "valor", nullable = false)
	private double valor;

	public PedidoItem(Produto produto, int quantidade) {
		super();

		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = produto.getValorUnitario() * quantidade;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setproduto(Produto produto) {
		this.produto = produto;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public Produto getproduto() {
		return this.produto;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public double getValor() {
		return this.valor;
	}
	
}