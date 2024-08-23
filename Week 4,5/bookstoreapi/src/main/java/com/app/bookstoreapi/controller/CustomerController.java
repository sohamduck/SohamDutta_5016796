package com.app.bookstoreapi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.app.bookstoreapi.entity.Customer;
import com.app.bookstoreapi.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @PostMapping
    public ResponseEntity<String> insertCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEntireCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateEntireCustomer(id,customer);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAll(){
        customerService.deleteAll();
        return ResponseEntity.ok("All Customers deleted successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(Long id){
        return customerService.deleteById(id);
    }
}
