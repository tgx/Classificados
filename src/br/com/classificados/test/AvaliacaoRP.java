package br.com.classificados.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.classificados.model.Profissional;
import br.com.classificados.model.TipoServico;

public class AvaliacaoRP {
	//TODO
	public static void main(String[] args) {
		
		/**
		 * VERIFICAR DEPOIS
		 */

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("classificado");

		EntityManager em = emf.createEntityManager();

		Profissional pro = new Profissional();
		TipoServico servico = new TipoServico();

		servico = em.find(TipoServico.class, 1L);
		pro = em.find(Profissional.class, 2L);

		em.getTransaction().begin();

		String sql = "SELECT avg(a.nota) FROM  avaliacao a  where  a.servico = "
				+ servico.getIdTipoServico();

		TypedQuery<Double> qry = em.createQuery(sql, Double.class);

		Double resultList;
		resultList = qry.getSingleResult();
		pro.setNota(resultList);

		em.close();

		System.out.println("Profissional: " + pro.getNome() + "\nAvaliacao: "
				+ resultList + "\nServico: ");
	}

}
