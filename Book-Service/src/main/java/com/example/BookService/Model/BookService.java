package com.example.BookService.Model;

import java.util.Collection;
import java.util.List;

public class BookService<Items> {
	
	private List<Books> Items;
	  public BookService<Items>  book;
	@Override
	public String toString() {
		return "BookService [Items=" + Items + "]";
	}

	public List<Books> getItems() {
		return Items;
	}

	public void setItems(List<Books> items) {
		Items = items;
	}

	public BookService(List<Books> items) {
		super();
		Items = items;
	}
	
	public BookService() {
		super();
		
	}

	public BookService<Items> getItemsbyID() {
		
		return book;
	}

}
