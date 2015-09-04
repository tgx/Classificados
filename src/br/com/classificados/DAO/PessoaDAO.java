package br.com.classificados.DAO;

import javax.persistence.EntityManager;

import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.Pessoa;

public class PessoaDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public PessoaDAO(EntityManager entityManager) {
		this.em = entityManager;
	}

	Pessoa pessoa;

	public void salvar(Pessoa pessoa) {
		em.persist(pessoa);
	}

	public void excluir(Pessoa pessoa) {
		em.remove(pessoa);
	}

	public void alterar(Pessoa pessoa) {
		em.merge(pessoa);
	}

}
