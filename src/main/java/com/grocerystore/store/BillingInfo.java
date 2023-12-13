package com.grocerystore.store;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing_info")
public class BillingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product", length = 255)
    private String product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sell_cost")
    private int sellCost;

    @Column(name = "each_item_total_value")
    private int eachItemTotalValue;

    @Column(name = "customer_name", length = 255)
    private String customerName;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + quantity;
        result = prime * result + sellCost;
        result = prime * result + eachItemTotalValue;
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
        result = prime * result + ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
        result = prime * result + ((billingDateTime == null) ? 0 : billingDateTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BillingInfo other = (BillingInfo) obj;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        if (quantity != other.quantity)
            return false;
        if (sellCost != other.sellCost)
            return false;
        if (eachItemTotalValue != other.eachItemTotalValue)
            return false;
        if (customerName == null) {
            if (other.customerName != null)
                return false;
        } else if (!customerName.equals(other.customerName))
            return false;
        if (paymentStatus != other.paymentStatus)
            return false;
        if (billingDateTime == null) {
            if (other.billingDateTime != null)
                return false;
        } else if (!billingDateTime.equals(other.billingDateTime))
            return false;
        return true;
    }

    public BillingInfo() {
    }

    public BillingInfo(String product, int quantity, int sellCost, int eachItemTotalValue, String customerName,
            String paymentStatus, java.util.Date billingDateTime) {
        this.product = product;
        this.quantity = quantity;
        this.sellCost = sellCost;
        this.eachItemTotalValue = eachItemTotalValue;
        this.customerName = customerName;
        this.paymentStatus = paymentStatus;
        this.billingDateTime = billingDateTime;
    }

    @Override
    public String toString() {
        return "BillingInfo [id=" + id + ", product=" + product + ", quantity=" + quantity + ", sellCost=" + sellCost
                + ", eachItemTotalValue=" + eachItemTotalValue + ", customerName=" + customerName + ", paymentStatus="
                + paymentStatus + ", billingDateTime=" + billingDateTime + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSellCost() {
        return sellCost;
    }

    public void setSellCost(int sellCost) {
        this.sellCost = sellCost;
    }

    public int getEachItemTotalValue() {
        return eachItemTotalValue;
    }

    public void setEachItemTotalValue(int eachItemTotalValue) {
        this.eachItemTotalValue = eachItemTotalValue;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getBillingDateTime() {
        return billingDateTime;
    }

    public void setBillingDateTime(Date billingDateTime) {
        this.billingDateTime = billingDateTime;
    }

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "billing_date_time")
    private Date billingDateTime;

}
