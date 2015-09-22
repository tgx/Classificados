package br.com.classificados.MB;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.classificados.DAO.TipoServicoDAO;
import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.TipoServico;

@ManagedBean
public class TipoServicoMB {

	private TipoServico tipoServico = new TipoServico();

	public TipoServico getServico() {
		return tipoServico;
	}

	public void setServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	private List<TipoServico> listaServicos;

	public List<TipoServico> getListaServico() {
		EntityManager em = JPAUtil.getEntityManager();

		String sql = "select s from tiposervico s";

		TypedQuery<TipoServico> qry = em.createQuery(sql, TipoServico.class);

		listaServicos = qry.getResultList();

		return listaServicos;
	}

	public void cadastrar() {
		EntityManager em = JPAUtil.getEntityManager();
		TipoServicoDAO dao = new TipoServicoDAO(em);

		em.getTransaction().begin();
		dao.salvar(tipoServico);
		em.getTransaction().commit();
		em.close();

		tipoServico = new TipoServico();
	}

}
