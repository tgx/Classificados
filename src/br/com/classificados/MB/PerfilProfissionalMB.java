package br.com.classificados.MB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.Avaliacao;
import br.com.classificados.model.Profissional;
import br.com.classificados.model.TipoServico;

@ManagedBean(name = "perfilProfissionalMB")
@SessionScoped
public class PerfilProfissionalMB {

	Profissional profissional = new Profissional();
	TipoServico servico = new TipoServico();
	Avaliacao avaliacao = new Avaliacao();

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public TipoServico getServico() {
		return servico;
	}

	public void setServico(TipoServico servico) {
		this.servico = servico;
	}

	public void buscaProfissional(Profissional p, TipoServico servico) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		profissional = em.find(Profissional.class, p.getIdPessoa());
		servico = em.find(TipoServico.class, servico.getIdTipoServico());

		em.getTransaction().commit();
		em.close();

		go();
	}

	public String go() {
		return "perfilProfissional.xhtml";
	}
}
