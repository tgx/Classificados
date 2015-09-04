package br.com.classificados.report;

import br.com.classificados.model.Profissional;
import br.com.classificados.model.TipoServico;

public class AvaliacaoReport {
	private Profissional profissional;
	private float nota;
	private TipoServico tipoServico;

	public AvaliacaoReport(Float nota, Profissional pro, TipoServico tpServico) {
		this.nota = nota;
		this.profissional = pro;
		this.tipoServico = tpServico;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

}
