package com.danilovalerio.projmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danilovalerio.projmongo.domain.User;
import com.danilovalerio.projmongo.repository.UserRepository;

//Será uma classe de serviço de usuarío, podendo ser injetada em outras classes

@Service //notação para avisar o spring o tipo dessa classe
public class UserService {
	
	//Injeção para service acessar o repositório
	@Autowired
	private UserRepository repo; //com a notação @Autowired o Spring busca o tipo de objeto no projeto (injeção automática do Spring)
	
	public List<User> buscarTodos(){
		return repo.findAll();
	}

}
