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

		// Tipo de servico ***

		// '1', 'Sorveteiro'
		// '4', 'Pintor'
		// '2', 'Pedreiro'
		// '3', 'Padeiro'
		// '5', 'Encanador'
		// 6 - Diarista

		servico = em.find(TipoServico.class, 6L);

		// Id profissional
		// 1 -
		// 2 - Tiago
		// 3 - Joaquim
		// 4 - Maria
		// 5- Fernanda

		pro = em.find(Profissional.class, 4L);

		avalia.setProfissional(pro);
		avalia.setNota(5D); // nota de avaliacao
		avalia.setTipoServico(servico);

		em.persist(avalia);

		em.getTransaction().commit();
		em.close();

	}

}
