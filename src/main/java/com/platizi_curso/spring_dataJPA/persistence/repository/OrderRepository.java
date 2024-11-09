package com.platizi_curso.spring_dataJPA.persistence.repository;

import com.platizi_curso.spring_dataJPA.persistence.entities.OrderEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jonii
 */
@Repository
public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer>{
   
    public List< OrderEntity > findByDateAfter(LocalDateTime date);
    
    public List<OrderEntity> findAllByMethodIn(List<String> methods);
    
   
}
