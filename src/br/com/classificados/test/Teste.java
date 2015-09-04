package br.com.classificados.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.classificados.model.Profissional;
import br.com.classificados.model.TipoServico;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("classificado");

		EntityManager em = emf.createEntityManager();

		Profissional pessoa = new Profissional();
		TipoServico servico = new TipoServico();

		em.getTransaction().begin();

//		servico.setNmServico("Sorveteiro");
		servico = em.find(TipoServico.class, 1L);

		pessoa.setServico(servico);

		pessoa.setDescricao("Faz-se Picolé da massa");
		pessoa.setNome("Maria");
		pessoa.setEmail("m@hotmail.com");
		pessoa.setSenha("123");
		pessoa.setTelefone("5555-1234");

		em.persist(pessoa);
		em.persist(servico);
		em.getTransaction().commit();
		em.close();

	}
}
