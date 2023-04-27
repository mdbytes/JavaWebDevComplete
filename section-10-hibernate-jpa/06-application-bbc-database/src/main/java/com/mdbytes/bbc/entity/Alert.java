package com.mdbytes.bbc.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "alerts", schema = "bargain_buy_club", catalog = "")
public class Alert {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "alert_id")
    private int alertId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    ;
    @Basic
    @Column(name = "alert_price")
    private double alertPrice;

    public Alert() {
    }

    public Alert(double alertPrice) {
        this.alertPrice = alertPrice;
    }

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAlertPrice() {
        return alertPrice;
    }

    public void setAlertPrice(double alertPrice) {
        this.alertPrice = alertPrice;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertId=" + alertId +
                ", productId=" + product.getProductId() +
                ", userId=" + user.getUserId() +
                ", alertPrice=" + alertPrice +
                '}';
    }
}
