package br.com.classificados.DAO;

import javax.persistence.EntityManager;

import br.com.classificados.model.Avaliacao;

public class AvaliacaoDAO {

	private EntityManager em;

	public AvaliacaoDAO(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void avaliar(Avaliacao avaliacao) {
		em.persist(avaliacao);
	}

}
