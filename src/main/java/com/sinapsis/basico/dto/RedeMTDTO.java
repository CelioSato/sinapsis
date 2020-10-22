
package com.sinapsis.basico.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class RedeMTDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "{campo.codigo.obrigatorio}")
	private String codigo;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@NotEmpty(message = "{campo.tensao.obrigatorio}")
	private String tensao_nominal;
	
	private Integer idSubestacao;
	
	public RedeMTDTO() {
		
	}

	public RedeMTDTO(Integer id, String codigo, String nome, String tensao_nominal, Integer idSubestacao) {
		super();
		this.setId(id);
		this.codigo = codigo;
		this.nome = nome;
		this.tensao_nominal = tensao_nominal;
		this.idSubestacao = idSubestacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTensao_nominal() {
		return tensao_nominal;
	}

	public void setTensao_nominal(String tensao_nominal) {
		this.tensao_nominal = tensao_nominal;
	}

	public Integer getIdSubestacao() {
		return idSubestacao;
	}

	public void setIdSubestacao(Integer idSubestacao) {
		this.idSubestacao = idSubestacao;
	}
}
