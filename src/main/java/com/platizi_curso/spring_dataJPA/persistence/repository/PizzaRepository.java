package com.platizi_curso.spring_dataJPA.persistence.repository;

import com.platizi_curso.spring_dataJPA.persistence.entities.PizzaEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jonii
 */
@Repository
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    
    
    
    //Query Methods

    List<PizzaEntity>findAllByAvaiableTrueOrderByIdPizza();
    
    
    Optional<PizzaEntity> findFirstByAvaiableTrueAndNameIgnoreCase(String name);
    
    List<PizzaEntity> findAllByAvaiableTrueAndDescriptionContainingIgnoreCase(String description);

    int countByVeganTrue();
    
    List<PizzaEntity> findTop3ByAvaiableTrueAndPriceLessThanEqualOrderByPriceAsc(double price );
    
    
    
}
