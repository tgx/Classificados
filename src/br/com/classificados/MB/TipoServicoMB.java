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

	private TipoServico servico = new TipoServico();

	public TipoServico getServico() {
		return servico;
	}

	public void setServico(TipoServico servico) {
		this.servico = servico;
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
		dao.salvar(servico);
		em.getTransaction().commit();
		em.close();

		servico = new TipoServico();
	}

}
