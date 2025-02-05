
package com.platizi_curso.spring_dataJPA.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="order_item")
@IdClass(OrderItemId.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {
    
    @Id
    @Column(name="id_item", nullable = false)
    private Integer idItem;
    
    @Id
    @Column(name="id_order", nullable = false)
    private Integer idOrder;
    
   
    @Column(name="id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable=false, columnDefinition = "Decimal(2,1)")
    private Double quantity;
    
    @Column(nullable=false, columnDefinition = "Decimal(5,2)")
    private Double price;
    
    @OneToOne
    @JoinColumn(name="id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false )
    private PizzaEntity pizza;
    
  
    @ManyToOne
    @JoinColumn(name="id_order", referencedColumnName="id_order", insertable = false, updatable = false )
    @JsonIgnore
    private OrderEntity order;
    
  
}
