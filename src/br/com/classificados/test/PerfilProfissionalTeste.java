package br.com.classificados.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.classificados.model.Profissional;

public class PerfilProfissionalTeste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("classificado");

		EntityManager em = emf.createEntityManager();

		Profissional pro = new Profissional();

		pro = em.find(Profissional.class, 2L);

		em.close();

		System.out.println("Profissional: " + pro.getNome());

	}

}
