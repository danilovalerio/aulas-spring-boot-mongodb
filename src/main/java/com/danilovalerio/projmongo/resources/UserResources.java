package com.danilovalerio.projmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.inserir(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build(); //Created retorna o 201 quando criamos novo recurso
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){ 
		service.delete(id);
		return ResponseEntity.noContent().build(); 
		
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto);
		obj.setId(id);//garantimos que o objeto terá o id da transposição
		obj = service.atualizar(obj);
		
		return ResponseEntity.noContent().build(); //Created retorna o 201 quando criamos novo recurso
		
	}

}
