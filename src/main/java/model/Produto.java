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

	@Column(name = "valor", nullable = false)
	private double valor;

	@ManyToOne(optional = true)
	@JoinColumn(name = "codigofornecedor", foreignKey = @ForeignKey(name = "fk_produto_fornecedor"))
	private Fornecedor fornecedor;

	public Produto(String descricao, double valor) {
		super();

		this.descricao = descricao;
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(double valor) {
		this.valor = valor;
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

	public double getValor() {
		return this.valor;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}
}