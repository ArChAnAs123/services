package com.example.model;






import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection  = "favourites")
public class Favourite {
	
   
	
	private String BookId[];
	
	private String Bookid;
	private String username;
	public  String[]  getBookId() {
		return BookId;
	}
	public void setBookId( String[] bookId) {
		this.BookId=bookId;
	
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Favourite() {
		super();
	}
	public Favourite(String[] bkid, String username) {
		
			    this.BookId = bkid;
			    this.username = username;
			   
			 
	}
	public String getBookid() {
		return Bookid;
	}
	public void setBookid(String bookid) {
		Bookid = bookid;
	}
	
	
}