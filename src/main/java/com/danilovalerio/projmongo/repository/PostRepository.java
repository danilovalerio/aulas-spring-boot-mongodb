package com.danilovalerio.projmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danilovalerio.projmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ //Entidade User, Tipo de ID String
	//Extendendo o MogoRepository você permitem operações básicas de um CRUD 

}
