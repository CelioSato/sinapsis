package com.sinapsis.basico.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_REDE_MT")
public class RedeMT implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REDE_MT")
	private Integer id;
	
	@Column(unique = true, name = "CODIGO", nullable = false, length = 5)
	private String codigo;
	
	@Column(name = "NOME",nullable = false, length = 100)
	private String nome;
	
	@Column(name = "TENSAO_NOMINAL", columnDefinition="Decimal(5,2)")
	private Double tensao_nominal;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_subestacao")
	private Subestacao sub;
	
	public RedeMT() {
		
	}
	
	public RedeMT(Integer id, String codigo, String nome, Double tensao_nominal, Subestacao sub) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.tensao_nominal = tensao_nominal;
		this.sub = sub;
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

	public Double getTensao_nominal() {
		return tensao_nominal;
	}

	public void setTensao_nominal(Double tensao_nominal) {
		this.tensao_nominal = tensao_nominal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RedeMT other = (RedeMT) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Subestacao getSub() {
		return sub;
	}

	public void setSub(Subestacao sub) {
		this.sub = sub;
	}
	
}
