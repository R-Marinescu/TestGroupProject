package com.example.testgroupproject.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "products_order")
public class ProductsOrder {
    @EmbeddedId
    private ProductsOrderId id;

    @MapsId("fkOrderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FK_order_ID", nullable = false)
    private Order fkOrder;

    @MapsId("fkProductId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FK_product_ID", nullable = false)
    private Product fkProduct;

    @Column(name = "product_Qty")
    private Integer productQty;

    public ProductsOrderId getId() {
        return id;
    }

    public void setId(ProductsOrderId id) {
        this.id = id;
    }

    public Order getFkOrder() {
        return fkOrder;
    }

    public void setFkOrder(Order fkOrder) {
        this.fkOrder = fkOrder;
    }

    public Product getFkProduct() {
        return fkProduct;
    }

    public void setFkProduct(Product fkProduct) {
        this.fkProduct = fkProduct;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }

}