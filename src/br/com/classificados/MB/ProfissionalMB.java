package br.com.classificados.MB;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.classificados.DAO.ProfissionalDAO;
import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.Profissional;
import br.com.classificados.model.TipoServico;

@ManagedBean(name = "profissionalMB")
public class ProfissionalMB {

	private Profissional profissional = new Profissional();
	private TipoServico tipoServico = new TipoServico();

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public void salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		ProfissionalDAO dao = new ProfissionalDAO(em);

		profissional.setServico(tipoServico);
		em.getTransaction().begin();
		dao.salvar(profissional);
		em.getTransaction().commit();
		em.close();
		profissional = new Profissional();
		tipoServico = new TipoServico();
	}

	private List<Profissional> listaProfissionais;

	public List<Profissional> getListaProfissional() {
		EntityManager em = JPAUtil.getEntityManager();

		String sql = "select p from profissional p  GROUP BY p.profissional";
		// String sql_nota =
		// "select avg(a.nota) FROM avaliacao a GROUP BY a.profissional";

		TypedQuery<Profissional> qry = em.createQuery(sql, Profissional.class);

		listaProfissionais = qry.getResultList();

		em.close();

		return listaProfissionais;
	}

	public void buscar() {

		profissional = new Profissional();
		EntityManager em = JPAUtil.getEntityManager();

		profissional = em.find(Profissional.class, 2L);
		em.close();

	}

}
