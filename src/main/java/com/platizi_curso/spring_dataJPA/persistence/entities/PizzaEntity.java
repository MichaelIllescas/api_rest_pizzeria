
package com.platizi_curso.spring_dataJPA.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="pizza")
public class PizzaEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id_pizza", nullable = false)
    private int idPizza;
    
    @Column(nullable = false, length = 30, unique = true)
    private String name;
    
    @Column(nullable = false, length = 150)
    private String description;
    
    @Column(nullable=false, columnDefinition = "Decimal(5,2)")
    private Double price;
    
    @Column(columnDefinition = "TINYINT")
    private boolean vegetarian;
    
    @Column(columnDefinition = "TINYINT")
    private boolean vegan;
    
    @Column(columnDefinition = "TINYINT", nullable = false)
    private boolean avaiable;
}
