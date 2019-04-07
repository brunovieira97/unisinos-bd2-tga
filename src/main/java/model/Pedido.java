package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
	@SequenceGenerator(name = "seq_pedido", sequenceName = "s_pedido", allocationSize = 1)
	@Column(name = "codigopedido", nullable = false)
	private int codigo;

	@ManyToMany
	@JoinTable(
		name = "clientepedido",
		joinColumns = @JoinColumn(name = "codigopedido"),
		inverseJoinColumns = @JoinColumn(name = "codigocliente")
	)
	private Set<Cliente> clientes;

	@Column(name = "valortotal", nullable = false)
	private double valorTotal;

	@Column(name = "valorfrete", nullable = false)
	private double valorFrete;

	@Column(name = "situacao", nullable = false)
	private char situacao;

	@Column(name = "datapedido", nullable = false)
	private Date dataPedido;

	@ManyToOne(optional = true)
	@JoinColumn(name = "codigoenderecodestino", foreignKey = @ForeignKey(name = "fk_pedido_endereco"))
	private Endereco enderecoDestino;

	@OneToMany (mappedBy = "pedido")
	private Set<PedidoItem> itens;

	/**
	 * * Pedidos são sempre criados com situacao = 'P' (Pendente) e dataPedido = GetDate()
	*/
	public Pedido(double valorFrete, Endereco enderecoDestino) {
		super();

		this.clientes = new HashSet<Cliente>();
		this.valorFrete = valorFrete;
		this.situacao = 'P';
		this.dataPedido = new Date();
		this.enderecoDestino = enderecoDestino;
		this.itens = new HashSet<PedidoItem>();
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setEnderecoDestino(Endereco enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public void setItens(HashSet<PedidoItem> itens) {
		this.itens = itens;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public double getValorFrete() {
		return this.valorFrete;
	}

	public char getSituacao() {
		return this.situacao;
	}

	public Date getDataPedido() {
		return this.dataPedido;
	}

	public Endereco getEnderecoDestino() {
		return this.enderecoDestino;
	}

	public Set<PedidoItem> getItens() {
		return this.itens;
	}

}