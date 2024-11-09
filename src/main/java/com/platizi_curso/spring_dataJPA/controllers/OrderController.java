
package com.platizi_curso.spring_dataJPA.controllers;

import com.platizi_curso.spring_dataJPA.persistence.entities.OrderEntity;
import com.platizi_curso.spring_dataJPA.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonii
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    private final OrderService orderService;
    
    @Autowired
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }
    
    
    @GetMapping
    public ResponseEntity<List<OrderEntity>>getOrders(){
        return ResponseEntity.ok(this.orderService.getOrders());
    }
    
    
    @GetMapping("/today")
    public ResponseEntity<List<OrderEntity>> getTodayOrders(){
        return ResponseEntity.ok(orderService.getTodayOrders());
    }
     
    @GetMapping("/outside")
    public ResponseEntity<List<OrderEntity>> getOutsideOrders(){
        return ResponseEntity.ok(orderService.getOutSideOrders());
    }
    
    
}
