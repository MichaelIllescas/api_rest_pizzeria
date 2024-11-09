
package com.platizi_curso.spring_dataJPA.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Collate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pizza_order")
public class OrderEntity {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_order", nullable = false)
    private Integer idOrder;
    
    @Column (name ="id_customer", nullable = false, length=15)
    private String idCustomer;
    
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;
    
    @Column(nullable=false, columnDefinition = "Decimal(6,2)")
    private Double total; 
    
    @Column(nullable=false, columnDefinition = "CHAR(1)")
    private String method;
    
    @Column (name="aditional_notes", length= 200 )
    private String aditionalNotes;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    @JsonIgnore
    private CustomerEntity customer;
    
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItemEntity> items;
    
}   

