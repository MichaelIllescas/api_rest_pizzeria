
package com.platizi_curso.spring_dataJPA.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


@Entity
@Table(name="customer")
public class CustomerEntity {
    
    @Id
    @Column(name="id_customer", nullable=false, length = 15)
    private String idCustomer;
    
    @Column(nullable = false, length =20)
    private String name;

    @Column(nullable=false, length=100)
    private String adress;

    @Column(nullable=false, unique=true, length=50)
    private String email;

    @Column(nullable=false, length=20)
    private String phoneNumber;



}
