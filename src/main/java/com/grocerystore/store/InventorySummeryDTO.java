package com.grocerystore.store;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InventorySummeryDTO {
       int id;
       String product;
       BigDecimal quantity;
       BigDecimal sellCost;
       BigDecimal wholesaleCost;
       public InventorySummeryDTO(int id, String product, BigDecimal quantity, BigDecimal sellCost, BigDecimal purchaseCost,
            BigDecimal wholesaleCost,BigDecimal totalstockvalue, String partyName, LocalDate purchaseDate) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.sellCost = sellCost;
        this.wholesaleCost = wholesaleCost;
        this.purchaseCost = purchaseCost;
        this.totalstockvalue = totalstockvalue;
        this.partyName = partyName;
        this.purchaseDate = purchaseDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public BigDecimal getQuantity() {
        return quantity;
    }
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getSellCost() {
        return sellCost;
    }
    public void setSellCost(BigDecimal sellCost) {
        this.sellCost = sellCost;
    }
    public BigDecimal getPurchaseCost() {
        return purchaseCost;
    }
    public void setPurchaseCost(BigDecimal purchaseCost) {
        this.purchaseCost = purchaseCost;
    }
    public BigDecimal getTotalstockvalue() {
        return totalstockvalue;
    }
    public void setTotalstockvalue(BigDecimal totalstockvalue) {
        this.totalstockvalue = totalstockvalue;
    }
    public BigDecimal getWholesaleCost() {
        return wholesaleCost;
    }
    public void setWholesaleCost(BigDecimal wholesaleCost) {
        this.wholesaleCost = wholesaleCost;
    }
    public String getPartyName() {
        return partyName;
    }
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
       BigDecimal purchaseCost;
       BigDecimal totalstockvalue;
       String partyName;
       LocalDate purchaseDate;
}
