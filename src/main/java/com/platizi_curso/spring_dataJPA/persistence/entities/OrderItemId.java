
package com.platizi_curso.spring_dataJPA.persistence.entities;

import jakarta.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderItemId implements Serializable {
    
    
    private Integer idOrder;
    private Integer idItem;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idOrder);
        hash = 89 * hash + Objects.hashCode(this.idItem);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItemId other = (OrderItemId) obj;
        if (!Objects.equals(this.idOrder, other.idOrder)) {
            return false;
        }
        return Objects.equals(this.idItem, other.idItem);
    }
    
    
}
