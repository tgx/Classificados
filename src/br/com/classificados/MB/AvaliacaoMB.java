package br.com.classificados.MB;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.classificados.DAO.AvaliacaoDAO;
import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.Avaliacao;
import br.com.classificados.model.Profissional;
import br.com.classificados.report.AvaliacaoReport;

@ManagedBean(name = "avaliacaoMB")
public class AvaliacaoMB {

	private Profissional pro = new Profissional();
	private Avaliacao avaliacao = new Avaliacao();

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Profissional getPro() {
		return pro;
	}

	public void setPro(Profissional pro) {
		this.pro = pro;
	}

	public void avaliar(Profissional profissional) {
		EntityManager em = JPAUtil.getEntityManager();
		AvaliacaoDAO dao = new AvaliacaoDAO(em);

	}

	private List<Avaliacao> listaAvaliados;

	public List<Avaliacao> getListaAvaliacao() {
		EntityManager em = JPAUtil.getEntityManager();
		String sql = "SELECT a FROM avaliacao a GROUP BY a.profissional";

		TypedQuery<Avaliacao> qry = em.createQuery(sql, Avaliacao.class);

		listaAvaliados = qry.getResultList();

		return listaAvaliados;
	}

	private List<AvaliacaoReport> listaProfissionaisAvaliacao;

	@SuppressWarnings("unchecked")
	public List<AvaliacaoReport> getListAvaliacaoProfissional() {
		EntityManager em = JPAUtil.getEntityManager();

		String sql = "SELECT NEW br.com.classificados.report.AvaliacaoReport"
				+ "(avg(a.nota), "
				+ "a.profissional, "
				+ "a.tipoServico, "
				+ "count(a)) "
				+ "FROM avaliacao a "
				+ "GROUP BY a.tipoServico, "
				+ "a.profissional";
		Query qry = em.createQuery(sql);
		listaProfissionaisAvaliacao = qry.getResultList();
		em.close();

		return listaProfissionaisAvaliacao;
	}

}
