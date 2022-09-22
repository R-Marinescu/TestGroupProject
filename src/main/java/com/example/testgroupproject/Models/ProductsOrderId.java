package com.example.testgroupproject.Models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductsOrderId implements Serializable {
    private static final long serialVersionUID = 5376595607622256061L;
    @Column(name = "FK_order_ID", nullable = false)
    private Integer fkOrderId;

    @Column(name = "FK_product_ID", nullable = false)
    private Integer fkProductId;

    public Integer getFkOrderId() {
        return fkOrderId;
    }

    public void setFkOrderId(Integer fkOrderId) {
        this.fkOrderId = fkOrderId;
    }

    public Integer getFkProductId() {
        return fkProductId;
    }

    public void setFkProductId(Integer fkProductId) {
        this.fkProductId = fkProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductsOrderId entity = (ProductsOrderId) o;
        return Objects.equals(this.fkOrderId, entity.fkOrderId) &&
                Objects.equals(this.fkProductId, entity.fkProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkOrderId, fkProductId);
    }

}