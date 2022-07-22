package com.example.SpringWithMysql.controller;

import com.example.SpringWithMysql.model.BookModel;
import com.example.SpringWithMysql.repo.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
	@Autowired
	BookRepository bookRepository;
	@PostMapping("/booksave")
	public String insertBook(@RequestBody  BookModel book) {
		bookRepository.save(book);
		return "Your record is save successsfully";	
	}
	@PostMapping("/bulkbooksave")
	public String insertBulkBook(@RequestBody  List<BookModel> book) {
		bookRepository.saveAll(book);
		return "record is save successsfully";	
	}
	@GetMapping("/getallbooks")
	public List<BookModel> getBook(){
		return (List<BookModel>) bookRepository.findAll();
	}
	@GetMapping("/getbybookid/{bookId}")
	public Optional<BookModel> getBookById(@PathVariable("bookId") Long id){
		return  bookRepository.findById(id);
	}
	@DeleteMapping("deletebook/{bookId}")  
	public String deleteBook(@PathVariable("bookId") Long id)   
	{  
		bookRepository.deleteById(id);
		return "deleted successfully";
	}  
	  @PutMapping("/updatebook/{bookId}")
	  public String put(@PathVariable("bookId") long id, @RequestBody BookModel book) {
		  Optional<BookModel> book_data = bookRepository.findById(id);
		  if(book_data.isPresent()) {
			  BookModel _bookdata = book_data.get();
			  _bookdata.setBookAuthor(book.getBookAuthor());
			  _bookdata.setBookName(book.getBookName());
			  
			  bookRepository.save(_bookdata);
		  }
		  else {
			  return "Invalid id";
		  }
		  return "updated successfully";
	  }
}
