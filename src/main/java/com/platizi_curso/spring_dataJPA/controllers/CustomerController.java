
package com.platizi_curso.spring_dataJPA.controllers;

import com.platizi_curso.spring_dataJPA.persistence.entities.CustomerEntity;
import com.platizi_curso.spring_dataJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonii
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
    private final CustomerService customerService;
    
    
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }
    
    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> getByPhone(@PathVariable String phone){
        return ResponseEntity.ok(this.customerService.findByPhone(phone));
    }
    
    
}
