package com.danilovalerio.projmongo.resources;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danilovalerio.projmongo.domain.User;

@RestController
@RequestMapping(value="/usuarios")//endereço do endpoint
public class UserResources {
	
	@RequestMapping(method=RequestMethod.GET) //ou podemos colocar também @GetMapping
	//public List<User> findAll(){ retorna sem o tratamento http 
	public ResponseEntity<List<User>> findAll(){ //response entity retorna com tratamento http + status
		User maria = new User("1", "Maria Marrom", "mmarrom@gmail.com");
		User alex = new User("2", "Alex Blue", "ablue@gmail.com");
		
		List<User> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(lista);
		
	}

}
