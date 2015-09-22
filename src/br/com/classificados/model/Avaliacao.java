package br.com.classificados.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "avaliacao")
public class Avaliacao {
	
	@Id
	@GeneratedValue
	private Long idAvaliacao;
	private Double nota;
	// private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "servico")
	private TipoServico tipoServico;

	@OneToOne
	@JoinColumn(name = "profissional")
	private Profissional profissional;

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

}
