package com.danilovalerio.projmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danilovalerio.projmongo.domain.User;
import com.danilovalerio.projmongo.dto.UserDTO;
import com.danilovalerio.projmongo.services.UserService;

@RestController
@RequestMapping(value="/usuarios")//endereço do endpoint
public class UserResources {
	
	//Aqui realizamos a injeção de services para o controlador acessar o serviço
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) //ou podemos colocar também @GetMapping
	//public List<User> findAll(){ retorna sem o tratamento http 
	public ResponseEntity<List<UserDTO>> findAll(){ //response entity retorna com tratamento http + status
	
		List<User> lista = service.buscarTodos(); //faz uso do service para retornar os itens e guardar na lista
		List<UserDTO> listaDto = lista.stream() 
				.map(x -> new UserDTO(x))
				.collect(Collectors.toList()); //Transforma os objetos em objetos DTOs
		return ResponseEntity.ok().body(listaDto); // retorna a lista na requisição
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){ //@PathVariable indica que o id da url casa com o do parâmetro
		User obj = service.buscaPorId(id);
		
		return ResponseEntity.ok().body(new UserDTO(obj)); 
		
	}

}
