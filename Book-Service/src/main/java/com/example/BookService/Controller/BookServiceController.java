package com.example.BookService.Controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.BookService.Model.BookService;
import com.example.BookService.Model.Books;

@RestController

@CrossOrigin
public class BookServiceController<Items> {
	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	@Autowired
	private RestTemplate restTemplate;

	    @Autowired
	    WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{keyword}")
   public Object getItems(@PathVariable("keyword") String keyword){
		   BookService user = restTemplate.getForObject("https://www.googleapis.com/books/v1/volumes?q=" + keyword, BookService.class);
		   return user.getItems().stream().collect(Collectors.toList());
		
	}
	
	
	
}
