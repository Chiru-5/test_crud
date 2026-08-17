package com.pm.test_crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;


    public Book findBook(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book book){
        Optional<Book> existingBook =bookRepository.findById(id);
        if(existingBook.isPresent()){
            Book oldBook= existingBook.get();
            oldBook.setAuthor(book.getAuthor());
            oldBook.setTitle(book.getTitle());
            oldBook.setPrice(book.getPrice());
            return bookRepository.save(oldBook);
        }
        return null;

    }


    public void deleteBook(Long id){
        boolean book=bookRepository.existsById(id);
        if(book){
            bookRepository.deleteById(id);
        }
        else{
            System.out.println("Book not found");
        }
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
