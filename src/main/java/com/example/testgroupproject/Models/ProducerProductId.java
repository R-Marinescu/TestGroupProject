package com.example.testgroupproject.Models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProducerProductId implements Serializable {
    private static final long serialVersionUID = -998383409734341878L;
    @Column(name = "FK_producer_ID", nullable = false)
    private Integer fkProducerId;

    @Column(name = "FK_product_ID", nullable = false)
    private Integer fkProductId;

    public Integer getFkProducerId() {
        return fkProducerId;
    }

    public void setFkProducerId(Integer fkProducerId) {
        this.fkProducerId = fkProducerId;
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
        ProducerProductId entity = (ProducerProductId) o;
        return Objects.equals(this.fkProducerId, entity.fkProducerId) &&
                Objects.equals(this.fkProductId, entity.fkProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkProducerId, fkProductId);
    }

}