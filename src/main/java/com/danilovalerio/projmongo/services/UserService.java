package com.danilovalerio.projmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danilovalerio.projmongo.domain.User;
import com.danilovalerio.projmongo.dto.UserDTO;
import com.danilovalerio.projmongo.repository.UserRepository;
import com.danilovalerio.projmongo.services.exception.ObjectNotFoundException;

//Será uma classe de serviço de usuarío, podendo ser injetada em outras classes

@Service //notação para avisar o spring o tipo dessa classe
public class UserService {
	
	//Injeção para service acessar o repositório
	@Autowired
	private UserRepository repo; //com a notação @Autowired o Spring busca o tipo de objeto no projeto (injeção automática do Spring)
	
	public List<User> buscarTodos(){
		return repo.findAll();
	}
	
	public User buscaPorId(String id) {
	
		Optional<User> obj = repo.findById(id);
		//Se o bjeto por falso retorna uma exception com a msg.
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!")); 
		
	}
	
	public User inserir(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}

}
