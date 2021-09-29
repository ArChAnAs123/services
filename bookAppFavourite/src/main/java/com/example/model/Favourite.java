package com.example.model;






import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection  = "favourites")
public class Favourite {
	

	
	private String bookId;
	private String bookTitle;
	private String bookAuthors[];
	private String bookPublisher;
	private String bookPublishedDate;
	private String bookDescription;
	private String bookCategory;
	private String bookImage;
	
	private String username;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String[] getBookAuthors() {
		return bookAuthors;
	}
	public void setBookAuthors(String[] bookAuthors) {
		this.bookAuthors = bookAuthors;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookPublishedDate() {
		return bookPublishedDate;
	}
	public void setBookPublishedDate(String bookPublishedDate) {
		this.bookPublishedDate = bookPublishedDate;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Favourite(String bookId, String bookTitle, String[] bookAuthors, String bookPublisher, String bookDescription, String bookCategory, String bookImage, String bookPrice,
			String bookLanguage, String bookCurrencytCode, String username) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthors = bookAuthors;
		this.bookPublisher = bookPublisher;
		
		this.bookDescription = bookDescription;
		this.bookCategory = bookCategory;
		this.bookImage = bookImage;
		
		this.username = username;
	}
	public Favourite() {
		super();
	}
	
}