package br.com.classificados.MB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.classificados.DAO.PessoaDAO;
import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.Pessoa;
import br.com.classificados.model.Usuario;

@ManagedBean(name = "pessoaMB")
@ViewScoped
public class PessoaMB {

	private Usuario pessoa = new Usuario();

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Usuario pessoa) {
		this.pessoa = pessoa;
	}

	public void salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		PessoaDAO dao = new PessoaDAO(em);

		em.getTransaction().begin();
		// em.persist(pessoa);
		dao.salvar(pessoa);
		em.getTransaction().commit();
		em.close();
		pessoa = new Usuario();

	}

}
