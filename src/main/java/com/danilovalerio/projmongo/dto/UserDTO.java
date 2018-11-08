package com.danilovalerio.projmongo.dto;

import java.io.Serializable;

import com.danilovalerio.projmongo.domain.User;

/*DTO - Data Transfer Object 
 * Serve para projetar somente os dados de interesse para cada requisição
 * Se quero ver só nome e data de nascimento no registro completo de cliente pode utilizar DTO
 * para otimizar o trafego na rede e não expor outros dados cruciais daquele cadastro
 */
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String email;
	
	public UserDTO() {
	}
	
	//Construtor para instanciar automaticamente um objeto UserDTO a partir de User 
	public UserDTO(User obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
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
	
	

}
