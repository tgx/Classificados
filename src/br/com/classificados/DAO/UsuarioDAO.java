package br.com.classificados.DAO;

import javax.persistence.EntityManager;

import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.Usuario;

public class UsuarioDAO {

	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}

	private EntityManager em = JPAUtil.getEntityManager();

	public void salvar(Usuario usuario) {
		em.persist(usuario);
	}

	public void remover(Usuario usuario) {
		em.remove(usuario);
	}

}
