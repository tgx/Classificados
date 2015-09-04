package br.com.classificados.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "profissional")
public class Profissional extends Pessoa {

	@OneToOne
	@JoinColumn(name = "idServico")
	private TipoServico tipoServico;
	private String descricao;
	private Double nota;

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Profissional() {
		super(TipoPessoa.Profissional);
	}

	public TipoServico getServico() {
		return tipoServico;
	}

	public void setServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
