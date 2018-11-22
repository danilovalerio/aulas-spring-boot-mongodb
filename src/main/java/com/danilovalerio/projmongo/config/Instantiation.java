package com.danilovalerio.projmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.danilovalerio.projmongo.domain.Post;
import com.danilovalerio.projmongo.domain.User;
import com.danilovalerio.projmongo.repository.PostRepository;
import com.danilovalerio.projmongo.repository.UserRepository;

//Classe para configuração inicial que insere dados para nossos testes
@Configuration //para o Spring entender que se trata de uma configuração
public class Instantiation implements CommandLineRunner {

	//Injeta o Repository para operações com o banco de dados
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));//Horário de Greenwich Londres
		
		userRepository.deleteAll(); //limpa a coleção no mongodb
		postRepository.deleteAll(); //limpa a coleção de posts
		
		//Aqui recebe os dados iniciais para carga do sistema
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); //null porque o banco que gera o Id
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//Posts Iniciais
		Post post1 = new Post(null, sdf.parse("29/10/2018"), "Partiu viagem", "Vou para SP Manow. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("10/11/2018"), "Bom dia", "Acordei muito feliz!", maria);
		
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); //salva os dados no db
		postRepository.saveAll(Arrays.asList(post1, post2)); //salva os dados no db
		
	}

}
