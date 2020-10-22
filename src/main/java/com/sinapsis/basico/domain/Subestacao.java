package com.sinapsis.basico.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_SUBESTACAO")
public class Subestacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SUBESTACAO")
	private Integer id;
	
	@Column(unique = true, name = "CODIGO", nullable = false, length = 3)
	@NotEmpty(message = "{campo.codigo.obrigatorio}")
	private String codigo;
	
	@Column(name = "NOME",nullable = false, length = 100)
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@Column(name = "LATITUDE", columnDefinition="Decimal(15,13)")
	private Double latitude;
	
	@Column(name = "LONGITUDE", columnDefinition="Decimal(15,13)")
	private Double longitude;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "sub")
	private List<RedeMT> redes = new ArrayList<>();
	
	public Subestacao() {
		
	}

	public Subestacao(Integer id, String codigo, String nome, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.latitude =  latitude;
		this.longitude = longitude;
	}
	
	//(longitude == null) ? null: longitude;

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

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public List<RedeMT> getRedes() {
		return redes;
	}

	public void setRedes(List<RedeMT> redes) {
		this.redes = redes;
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
		Subestacao other = (Subestacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
