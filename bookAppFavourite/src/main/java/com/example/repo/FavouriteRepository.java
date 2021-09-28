package com.example.repo;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.Favourite;


@CrossOrigin(origins = "*")
public interface FavouriteRepository extends MongoRepository<Favourite, String>{

	

	
	public List<Favourite> findByUsername(String username);
	public Favourite findByusername(String username);
	

	public Favourite deleteByBookIdAndUsername(String bookid, String username);
	
	public List<Favourite> findByBookIdAndUsername(String id,String username);

	public Favourite deleteByusername(String username);
	public Favourite deleteByBookId(String bookId);
	
	
	
}