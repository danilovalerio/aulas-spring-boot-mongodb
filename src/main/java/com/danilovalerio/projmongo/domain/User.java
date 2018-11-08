package com.danilovalerio.projmongo.domain;

//para que os dados trafeguem por redes e arquivos no formato de bytes
import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document //notação para indicar que é uma coleção do mongodb ou @Document(collection="user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id //para indicar que o atributo abaixo é o Id no mongodb
	private String id;
	private String nome;
	private String email;
	
	public User() {
	}

	public User(String id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
