package com.app.bookstoreapi.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.bookstoreapi.entity.Book;
import com.app.bookstoreapi.service.BookService;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
    @GetMapping("/title/{title}")
    public Optional<Book> getBookByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }
    @GetMapping("/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return bookService.getBookByAuthor(author);
    }
    @GetMapping("/price/{price}")
    public List<Book> getBookByPrice(@PathVariable Double price){
        return bookService.getBookByPrice(price);
    }
    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        return bookService.getBookByIsbn(isbn);
    }
    @PostMapping
    public ResponseEntity<Book> insertBook(@RequestBody Book book){
        Book new_book=bookService.saveBook(book);
        return ResponseEntity.created(URI.create("/books/"+new_book.getId())).body(new_book);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook=bookService.updateBook(id,book);
        return ResponseEntity.ok(updatedBook);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateBookPrice(@PathVariable Long id, @RequestBody Double price){
        Book updatedBook=bookService.updateBookPrice(id,price);
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully !");
    }
}
