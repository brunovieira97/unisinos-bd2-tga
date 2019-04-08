package model;

import javax.persistence.*;

public final class TGA {
    public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd2_tga_persistence_unit");
		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();

			Endereco enderecoClienteA = new Endereco(
				"Av. Unisinos",
				"950",
				"São Leopoldo",
				"Rio Grande do Sul"
			);

			// Cria registro de endereço separadamente
			Endereco enderecoClienteB = new Endereco(
				"Av. Exemplo",
				"20",
				"Cidade X",
				"São Paulo"
			);

			em.persist(enderecoClienteA);
			em.persist(enderecoClienteB);

			// Cria cliente informando diretamente o endereço
			Cliente clienteA = new Cliente(
				"João Silva",
				enderecoClienteA
			);

			// Define CPF para o cliente A
			clienteA.setCPF("012.345.678-90");

			em.persist(clienteA);

			// Cria segundo cliente, utilizando o endereço separado criado anteriormente
			Cliente clienteB = new Cliente(
				"Jonas Souza",
				enderecoClienteB
			);

			em.persist(clienteB);

			// Cria fornecedor
			Fornecedor fornecedor = new Fornecedor(
				"Empresa X Ltda."
			);

			// Define um CNPJ para o fornecedor criado
			fornecedor.setCNPJ("01.234.567/8901-23");

			em.persist(fornecedor);

			// Cria dois produtos vinculados ao fornecedor 
				Produto produtoA = new Produto(
					"Notebook",
					2500.00,
					fornecedor
				);

				Produto produtoB = new Produto(
					"Televisão HD",
					1499.90,
					fornecedor
				);

			em.persist(produtoA);
			em.persist(produtoB);

			// Cria um pedido destinado ao endereço do cliente A
			Pedido pedido = new Pedido(
				clienteA.getEndereco()
			);

			// Adiciona um item ao pedido
			pedido.addItem(
				new PedidoItem(
					produtoA,
					1
				)
			);

			// Gera um item de pedido separadamente
			PedidoItem item2 = new PedidoItem(
				produtoB,
				2
			);

			// Adiciona o segundo item ao pedido já existente
			pedido.addItem(item2);

			// Vincula o pedido aos clientes A e B
			pedido.getClientes().add(clienteA);
			pedido.getClientes().add(clienteB);

			em.persist(pedido);

			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

    }
}
