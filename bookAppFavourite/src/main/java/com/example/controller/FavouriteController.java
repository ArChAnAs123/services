package com.example.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Favourite;
import com.example.repo.FavouriteRepository;
import com.example.service.FavouriteService;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class FavouriteController {
	@Autowired
	private FavouriteService fs;
	@Autowired
	private FavouriteRepository repo;
	
	@GetMapping(value="/user")
	public String welcome() {
		return "welcome..|";
	}
	@GetMapping("/bookApp/favourites/{username}")
	public ResponseEntity<?> getBookByFavouriteByIdAndUsername (@PathVariable("username") String username) 
	{
		
		ResponseEntity<?> rs=null;
		try {
			List<Favourite> b=fs.getAllFavourite ( username);
			rs=ResponseEntity.status(HttpStatus.OK).body(b);
		}
		catch(Exception e)
		{
			rs=ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return rs;
	}
	@GetMapping("/bookApp/{username}")
	public ResponseEntity<?> findByUsername (@PathVariable ("username") String username) 
	{
		
		ResponseEntity<?> rs=null;
		try {
			List<Favourite> b=fs.getAllFavourite(username);
			rs=ResponseEntity.status(HttpStatus.OK).body(b);
		}
		catch(Exception e)
		{
			rs=ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return rs;
	}
	
	@GetMapping(value="/", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Favourite> getStudents(){
		return fs.fetchAllUsers();
		
	}
	
	
	
	@PostMapping("/bookApp/addToFavourites")
	public ResponseEntity<?> saveBook(@RequestBody Favourite b) 
	{
		ResponseEntity<?> rs=null;
		try
		{
			Favourite bk=fs.saveFavourite(b);
			if(bk!=null)
			{
				rs=ResponseEntity.status(HttpStatus.CREATED).build();
			}
			else
			{
				rs=ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		catch(Exception e)
		{
			rs=ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return rs;
	}

	
	 @DeleteMapping("/delete/{bookid}/{username}")
	 public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("bookid") String bookid, @PathVariable("username") String username) {
	   try {
	     repo.deleteByBookIdAndUsername(bookid,username);
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	   } catch (Exception e) {
	     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	 }
	
	 @DeleteMapping("/bookApp/deleteFromFavourite/{id}/{username}")
	  public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id, @PathVariable("username") String username) {
	    
	    ResponseEntity<?> rs=null;
		
			
			fs.deleteFromFavourite(id,username);
			
			
			rs=ResponseEntity.status(HttpStatus.OK).build();
			
		

		return rs;
	    
	  }


	
}
	
