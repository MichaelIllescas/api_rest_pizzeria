
package com.platizi_curso.spring_dataJPA.service;

import com.platizi_curso.spring_dataJPA.persistence.entities.PizzaEntity;
import com.platizi_curso.spring_dataJPA.persistence.repository.PizzaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonii
 */
@Service
public class PizzaService {
   
   // este objeto se esa para insertar sql directo en una query= private final JdbcTemplate jdbctemplate;

    @Autowired
    private final PizzaRepository pizzaRepository;
    
    
    @Autowired
    public PizzaService(PizzaRepository pizzaRepository ) {
        this.pizzaRepository = pizzaRepository;
    }

    /*
    EJEMPLO DE COMO USAR JDBCTEMPLATE CON SQL
    public List<PizzaEntity> getAll(){
            return this.jdbctemplate.query("SELECT * FROM pizza WHERE avaiable=0", new BeanPropertyRowMapper<>(PizzaEntity.class));
    };
    */
        
    public List<PizzaEntity>getAll(){
        return pizzaRepository.findAll();
    }
    
    public  PizzaEntity getById(int id){
        return pizzaRepository.findById(id).orElse(null);
    }
    
    public PizzaEntity save( PizzaEntity pizzaEntity){
        return this.pizzaRepository.save(pizzaEntity);
    }
     public Boolean exists(Integer id){
        return this.pizzaRepository.existsById(id);
    }
     public void delete(Integer id){
         pizzaRepository.deleteById(id);
     }
     
     public List<PizzaEntity>getAvailable(){
         System.out.println(this.pizzaRepository.countByVeganTrue());
         
         
         return this.pizzaRepository.findAllByAvaiableTrueOrderByIdPizza();
     }
      public PizzaEntity getByName(String name){
            return  this.pizzaRepository.findFirstByAvaiableTrueAndNameIgnoreCase(name).orElseThrow(()-> new RuntimeException("La pizza no existe."));
      }
     public List <PizzaEntity>getWhit(String ingredient){
         return this.pizzaRepository.findAllByAvaiableTrueAndDescriptionContainingIgnoreCase(ingredient);
     }
     public List<PizzaEntity> getCheapest(double price){
         return this.pizzaRepository.findTop3ByAvaiableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
         
     }    
         
   
}
