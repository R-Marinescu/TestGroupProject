package com.example.testgroupproject.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "producer_products")
public class ProducerProduct {
    @EmbeddedId
    private ProducerProductId id;

    @MapsId("fkProducerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FK_producer_ID", nullable = false)
    private Producer fkProducer;

    @MapsId("fkProductId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FK_product_ID", nullable = false)
    private Product fkProduct;

    public ProducerProductId getId() {
        return id;
    }

    public void setId(ProducerProductId id) {
        this.id = id;
    }

    public Producer getFkProducer() {
        return fkProducer;
    }

    public void setFkProducer(Producer fkProducer) {
        this.fkProducer = fkProducer;
    }

    public Product getFkProduct() {
        return fkProduct;
    }

    public void setFkProduct(Product fkProduct) {
        this.fkProduct = fkProduct;
    }

}