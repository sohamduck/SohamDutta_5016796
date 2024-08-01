package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void serviceMethod(){
        if(bookRepository==null){
            throw new IllegalStateException("BookRepository is not set !");
        }
        System.out.println("BookRepository is succesfully injected ...");
    }
    public void printBookRepository(){
        System.out.println("BookRepository Instance : "+bookRepository);
    }
}
