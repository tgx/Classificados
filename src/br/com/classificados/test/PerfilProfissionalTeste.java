package br.com.classificados.test;

import java.text.NumberFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.classificados.model.Avaliacao;
import br.com.classificados.model.Profissional;
import br.com.classificados.model.TipoServico;
import br.com.classificados.report.AvaliacaoReport;

public class PerfilProfissionalTeste {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("classificado");

		EntityManager em = emf.createEntityManager();

		Profissional pro = new Profissional();
		TipoServico servico = new TipoServico();

		servico = em.find(TipoServico.class, 1L);
		pro = em.find(Profissional.class, 4L);

		List<AvaliacaoReport> listaAvaliacoes;

		String sql = "SELECT NEW br.com.classificados.report.AvaliacaoReport(avg(a.nota), a.profissional, a.tipoServico, count(a)) FROM avaliacao a GROUP BY a.tipoServico, a.profissional";

//		String sql = "SELECT new br.com.classificados.report.AvaliacaoReport(avg(a.nota), a.profissional, a.tipoServico) FROM avaliacao a GROUP BY a.tipoServico, a.profissional";
		
		
		Query qry = em.createQuery(sql);
		listaAvaliacoes = qry.getResultList();

		for (AvaliacaoReport avaliacao : listaAvaliacoes) {
			System.out.println("Nome: " + avaliacao.getProfissional().getNome() + "\nNota: "
					+ NumberFormat.getInstance().format(avaliacao.getNota())
					+ "\nServico:  " + avaliacao.getTipoServico().getNmServico() + "\nEmail: "
					+ avaliacao.getProfissional().getEmail() + "\nQndVoto: " + avaliacao.getQndVoto());

		}

	}

}
