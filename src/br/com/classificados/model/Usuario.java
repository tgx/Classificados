package br.com.classificados.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Usuario")
public class Usuario extends Pessoa {

	public Usuario() {
		super(TipoPessoa.Usuario);
	}
}
