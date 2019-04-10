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
	
	@Column(name = "situacao", nullable = false)
	private char situacao;

	@Column(name = "datapedido", nullable = false)
	private Date dataPedido;

	@ManyToOne(optional = true)
	@JoinColumn(name = "codigoendereco", foreignKey = @ForeignKey(name = "fk_pedido_endereco"))
	private Endereco endereco;

	@OneToMany (mappedBy = "pedido")
	private Set<PedidoItem> itens;

	public Pedido() {
		
	}

	/**
	 * * Pedidos são sempre criados com situacao = 'P' (Pendente) e dataPedido = GetDate()
	*/
	public Pedido(Endereco endereco) {
		super();

		this.clientes = new HashSet<Cliente>();
		this.situacao = 'P';
		this.dataPedido = new Date();
		this.endereco = endereco;
		this.itens = new HashSet<PedidoItem>();
	}

	public void addItem(PedidoItem item) {
		getItens().add(item);

		this.valorTotal += item.getValor();
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public char getSituacao() {
		return this.situacao;
	}

	public Date getDataPedido() {
		return this.dataPedido;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public Set<PedidoItem> getItens() {
		return this.itens;
	}

}