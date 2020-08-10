package com.washer.washerauth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.washer.washerauth.pojo.Washer;


public interface WasherRepo extends MongoRepository<Washer, String> {
	


}
