
package com.platizi_curso.spring_dataJPA.controllers;

import com.platizi_curso.spring_dataJPA.persistence.entities.PizzaEntity;
import com.platizi_curso.spring_dataJPA.service.PizzaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonii
 */
@RestController
@RequestMapping("/api/pizza")
public class PizzaController {
    private final PizzaService pizzaService;
    
    @Autowired
    public PizzaController(PizzaService pizzaService){
        this.pizzaService=pizzaService;
    }
    
    
    @GetMapping("/")
    public ResponseEntity<List<PizzaEntity>> getAll(){
        return ResponseEntity.ok(pizzaService.getAll());
         
    } 
     @GetMapping("/{idPizza}")
    public ResponseEntity <PizzaEntity> getAll(@PathVariable int idPizza){
        return ResponseEntity.ok(pizzaService.getById(idPizza));
         
    } 
    
       @PostMapping
    public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizzaEntity) {
        if (pizzaEntity.getIdPizza() == 0 || !this.pizzaService.exists(pizzaEntity.getIdPizza())) {
            return ResponseEntity.ok(pizzaService.save(pizzaEntity));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
     
    
   
    @PutMapping
    public ResponseEntity<PizzaEntity>update(@RequestBody PizzaEntity pizaEntity){
       if(pizaEntity.getIdPizza() !=0 && this.pizzaService.exists(pizaEntity.getIdPizza() ))
       {
            return ResponseEntity.ok(pizzaService.save(pizaEntity));
       }
       else{
          return  ResponseEntity.badRequest().build();
       }
    }
    
    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> delete (@PathVariable int idPizza){
        if(this.pizzaService.exists(idPizza)){
            this.pizzaService.delete(idPizza);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
         }
         
    }
    
     @GetMapping("/available")
     public ResponseEntity<List<PizzaEntity>> getAvailable(){
         return ResponseEntity.ok(this.pizzaService.getAvailable());
     }

     @GetMapping("/available/{name}")
     public ResponseEntity <PizzaEntity> getByNAme(@PathVariable String name){
         return ResponseEntity.ok(this.pizzaService.getByName(name));
     }
    
     @GetMapping("/available/ingredient/{ingredient}")
     public ResponseEntity<List<PizzaEntity>>getWhitIngredient(@PathVariable String ingredient){
         return ResponseEntity.ok(this.pizzaService.getWhit(ingredient));
        }
     
     @GetMapping("/cheapest/{price}")
     public  ResponseEntity <List<PizzaEntity>> getCheapestPizzas(@PathVariable double price){
     
     return ResponseEntity.ok(pizzaService.getCheapest(price));
     }
     
     
     
}
