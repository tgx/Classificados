package br.com.classificados.report;

import br.com.classificados.model.Profissional;
import br.com.classificados.model.TipoServico;

public class AvaliacaoReport {

	private Profissional profissional;
	private Double nota;
	private TipoServico tipoServico;
	private long qndVoto;

	public AvaliacaoReport(Double nota, Profissional profissional,
			TipoServico tipoServico, long qndVoto) {
		this.nota = nota;
		this.profissional = profissional;
		this.tipoServico = tipoServico;
		this.qndVoto = qndVoto;
	}

	public AvaliacaoReport() {
	}

	public long getQndVoto() {
		return qndVoto;
	}

	public void setQndVoto(long qndVoto) {
		this.qndVoto = qndVoto;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

}
