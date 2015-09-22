package br.com.classificados.MB;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.classificados.factory.JPAUtil;
import br.com.classificados.model.Profissional;

@ManagedBean(name = "perfilProfissionalMB")
public class PerfilProfissionalMB {

	Profissional profissional = new Profissional();

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public void buscaProfissional(Profissional p) {
		EntityManager em = JPAUtil.getEntityManager();
		Profissional pro = new Profissional();

		System.out
				.println("###################################################\n"
						+ " P "
						+ p.getNome()
						+ " "
						+ p.getIdPessoa()
						+ "\n######################################");

		pro = em.find(Profissional.class, p.getIdPessoa());
		this.profissional = pro;

		System.out
				.println("###################################################\n"
						+ " Pro "
						+ profissional.getNome()
						+ profissional.getIdPessoa()
						+ "\n######################################");

		em.close();
	}
}
