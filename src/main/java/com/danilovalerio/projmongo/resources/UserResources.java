package com.danilovalerio.projmongo.resources;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danilovalerio.projmongo.domain.User;
import com.danilovalerio.projmongo.services.UserService;

@RestController
@RequestMapping(value="/usuarios")//endereço do endpoint
public class UserResources {
	
	//Aqui realizamos a injeção de services para o controlador acessar o serviço
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) //ou podemos colocar também @GetMapping
	//public List<User> findAll(){ retorna sem o tratamento http 
	public ResponseEntity<List<User>> findAll(){ //response entity retorna com tratamento http + status
	
		List<User> lista = service.buscarTodos(); //faz uso do service para retornar os itens e guardar na lista
		return ResponseEntity.ok().body(lista); // retorna a lista na requisição
		
	}

}
