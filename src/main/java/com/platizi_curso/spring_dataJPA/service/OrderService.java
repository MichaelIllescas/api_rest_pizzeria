
package com.platizi_curso.spring_dataJPA.service;

import com.platizi_curso.spring_dataJPA.persistence.entities.OrderEntity;
import com.platizi_curso.spring_dataJPA.persistence.repository.OrderRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonii
 */
@Service
public class OrderService {
    
    final private OrderRepository orderRepository;
    
    private final static String DELIBERY= "D";
    private final static String CARRYOUT= "C";
    private final static String ON_SITE= "S";
    
    
    
    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    
    public List<OrderEntity> getOrders(){
        return orderRepository.findAll();
    }
    
    public List<OrderEntity> getTodayOrders(){
    
        LocalDateTime today= LocalDate.now().atTime(0, 0);
        return this.orderRepository.findByDateAfter( today);
    }
    
    
    public List<OrderEntity> getOutSideOrders(){
        List<String> methods =Arrays.asList(DELIBERY, CARRYOUT);
        return this.orderRepository.findAllByMethodIn(methods);
    }
    
    
    
}
