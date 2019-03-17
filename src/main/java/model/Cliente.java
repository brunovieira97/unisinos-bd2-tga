package model;

public class Cliente {
	private int codigoCliente;
	private String nome, CPF;

	public Cliente(String nome, String CPF) {
		super();
		this.nome = nome;
		this.CPF = CPF;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public int getCodigoCliente() {
		return this.codigoCliente;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCPF() {
		return this.CPF;
	}
}