package com.pm.test_crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/book/{id}")
    public Book getBookById(Long id){
        return  bookService.findBook(id);
    }
}
