package com.pm.test_crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/book/{id}")
    public Book getBookById(Long id){
        return  bookService.findBook(id);
    }


    @PostMapping("/savebook")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }


    @GetMapping("/findBook/{id}")
    public ResponseEntity<Book> findBook(@PathVariable Long id){
        Book book =bookService.findBookById(id);
        if(book!=null){
            return new ResponseEntity<>(book, HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/allBooks")
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> books=bookService.findAll();
        if(books.isEmpty()){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(books, HttpStatus.FOUND);
        }
    }


    @PutMapping("/updatedBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook=bookService.updateBook(id, book);
        if(updatedBook!=null){
            return new ResponseEntity<>(updatedBook, HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.NOT_MODIFIED);
        }
    }


    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
