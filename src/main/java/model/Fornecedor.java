package model;

import javax.persistence.*;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fornecedor")
	@SequenceGenerator(name = "seq_fornecedor", sequenceName = "s_fornecedor", allocationSize = 1)
	@Column(name = "codigofornecedor", nullable = false)
	private int codigo;
	
	@Column(name = "razaosocial", nullable = false)
	private String razaoSocial;

	@Column(name = "cnpj", nullable = true)
	private String CNPJ;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "codigoendereco", foreignKey = @ForeignKey(name = "fk_fornecedor_endereco"))
	private Endereco endereco;

	public Fornecedor(String razaoSocial) {
		super();

		this.razaoSocial = razaoSocial;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public String getCNPJ() {
		return this.CNPJ;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}
}