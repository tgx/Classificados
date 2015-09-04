package br.com.classificados.DAO;

import javax.persistence.EntityManager;

import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.TipoServico;

public class TipoServicoDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public TipoServicoDAO(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void salvar(TipoServico servico) {
		em.persist(servico);
	}

	public void excluir(TipoServico servico) {
		em.remove(servico);
	}

}
