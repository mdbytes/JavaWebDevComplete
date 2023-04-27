package com.mdbytes.bbc.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products", schema = "bargain_buy_club", catalog = "")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "product_url", nullable = false)
    private String productUrl;

    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "recent_price")
    private Double recentPrice;
    @Basic
    @Column(name = "last_updated")
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "product")
    private List<Alert> alerts;

    public Product() {
    }

    public Product(String productUrl, String productName) {
        this.productUrl = productUrl;
        this.productName = productName;
        this.recentPrice = 0.0;
        this.lastUpdated = Date.valueOf(LocalDate.now());
    }

    public Product(String productUrl, String productName, Double recentPrice, Date lastUpdated) {
        this.productUrl = productUrl;
        this.productName = productName;
        this.recentPrice = recentPrice;
        this.lastUpdated = lastUpdated;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getRecentPrice() {
        return recentPrice;
    }

    public void setRecentPrice(Double recentPrice) {
        this.recentPrice = recentPrice;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productUrl='" + productUrl + '\'' +
                ", productName='" + productName + '\'' +
                ", recentPrice=" + recentPrice +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
