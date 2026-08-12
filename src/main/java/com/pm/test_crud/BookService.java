package com.pm.test_crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;


    public Book findBook(Long id){
        return bookRepository.findById(id).orElse(null);
    }
}
