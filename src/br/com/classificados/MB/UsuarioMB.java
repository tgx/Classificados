package br.com.classificados.MB;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.classificados.DAO.UsuarioDAO;
import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.Usuario;

@ManagedBean
public class UsuarioMB {
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void cadastrar() {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);

		em.getTransaction().begin();
		dao.salvar(usuario);
		em.getTransaction().commit();
		em.close();

		usuario = new Usuario();

	}

}
