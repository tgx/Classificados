package br.com.classificados.DAO;

import javax.persistence.EntityManager;

import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.Profissional;

public class ProfissionalDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public Profissional profissional;

	public ProfissionalDAO(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void salvar(Profissional profissional) {
		em.persist(profissional);
	}

}
