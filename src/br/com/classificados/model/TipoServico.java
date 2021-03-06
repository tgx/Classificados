package br.com.classificados.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "tiposervico")
public class TipoServico {

	@Id
	@GeneratedValue
	private Long idTipoServico;
	private String nmServico;

	@OneToOne
	private Avaliacao avaliacao;

	public Long getIdTipoServico() {
		return idTipoServico;
	}

	// public void setIdTipoServico(Long idTipoServico) {
	// this.idTipoServico = idTipoServico;
	// }

	public String getNmServico() {
		return nmServico;
	}

	public void setNmServico(String nmServico) {
		this.nmServico = nmServico;
	}
}
