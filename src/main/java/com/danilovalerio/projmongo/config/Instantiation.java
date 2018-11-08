package com.danilovalerio.projmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.danilovalerio.projmongo.domain.User;
import com.danilovalerio.projmongo.repository.UserRepository;

//Classe para configuração inicial que insere dados para nossos testes
@Configuration //para o Spring entender que se trata de uma configuração
public class Instantiation implements CommandLineRunner {

	//Injeta o Repository para operações com o banco de dados
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll(); //limpa a coleção no mongodb
		
		//Aqui recebe os dados iniciais para carga do sistema
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); //null porque o banco que gera o Id
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); //salva os dados no db
		
	}

}
