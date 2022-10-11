package com.example.testgroupproject.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "products_order")
public class ProductsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prodOrder_Id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FK_order_ID")
    private Order fkOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FK_product_ID")
    private Product fkProduct;

    @Column(name = "product_Qty")
    private Integer productQty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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