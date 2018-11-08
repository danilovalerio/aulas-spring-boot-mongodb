package com.danilovalerio.projmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danilovalerio.projmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{ //Entidade User, Tipo de ID String
	//Extendendo o MogoRepository você permitem operações básicas de um CRUD 

}
