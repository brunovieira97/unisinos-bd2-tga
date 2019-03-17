package model;

import javax.persistence.*;

@Entity
public class Produto {

	private int codigoProduto;
	private String descricao;
	private double preco;

	public Produto(String descricao, double preco) {
		super();

		this.descricao = descricao;
		this.preco = preco;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getCodigoProduto() {
		return this.codigoProduto;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public double getPreco() {
		return this.preco;
	}
}