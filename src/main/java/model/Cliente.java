package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
	@SequenceGenerator(name = "seq_cliente", sequenceName = "s_cliente", allocationSize = 1)
	@Column(name = "codigocliente", nullable = false)
	private int codigo;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = true)
	private String CPF;

	@ManyToOne(optional = true)
	@JoinColumn(name = "codigoendereco", foreignKey = @ForeignKey(name = "fk_cliente_endereco"))
	private Endereco endereco;

	@ManyToMany(mappedBy = "clientes")
	private Set<Pedido> pedidos;

	public Cliente(String nome) {
		super();

		this.nome = nome;
	}

	public Cliente(String nome, Endereco endereco) {
		super();

		this.nome = nome;
		this.endereco = endereco;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	private void setPedidos(HashSet<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCPF() {
		return this.CPF;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	private Set<Pedido> getPedidos() {
		return this.pedidos;
	}
}