package br.com.classificados.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.classificados.model.Avaliacao;
import br.com.classificados.model.Profissional;
import br.com.classificados.model.TipoServico;

public class TesteAvaliacao {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("classificado");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Avaliacao avalia = new Avaliacao();
		Profissional pro = new Profissional();
		TipoServico servico = new TipoServico();

		servico = em.find(TipoServico.class, 1L); 	// Tipo de servico
		pro = em.find(Profissional.class, 4L); 		// Id profissional

		avalia.setProfissional(pro);
		avalia.setNota(3f);							// nota de avaliacao
		avalia.setTipoServico(servico);

		em.persist(avalia);

		em.getTransaction().commit();
		em.close();

	}

}
