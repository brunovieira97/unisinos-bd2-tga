package model;

import javax.persistence.*;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	@SequenceGenerator(name = "seq_produto", sequenceName = "s_produto", allocationSize = 1)
	private int codigo;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "valorunitario", nullable = false)
	private double valorUnitario;

	@ManyToOne(optional = true)
	@JoinColumn(name = "codigofornecedor", foreignKey = @ForeignKey(name = "fk_produto_fornecedor"))
	private Fornecedor fornecedor;

	public Produto(String descricao, double valorUnitario) {
		super();

		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
	}

	public Produto(String descricao, double valorUnitario, Fornecedor fornecedor) {
		super();

		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.fornecedor = fornecedor;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public double getValorUnitario() {
		return this.valorUnitario;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}
}