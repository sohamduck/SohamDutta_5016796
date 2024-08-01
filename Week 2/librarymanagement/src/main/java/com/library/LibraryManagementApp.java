package com.library;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.*;

public class LibraryManagementApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService=context.getBean("bookService",BookService.class);
        bookService.serviceMethod();
        bookService.printBookRepository();

        context.close();
    }
}