package com.grocerystore.store;

public class Billing {
    String item;

    public String getItem() {
        return item;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result + quantity;
        result = prime * result + sellCost;
        result = prime * result + eachItemtotalValue;
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
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
        Billing other = (Billing) obj;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (quantity != other.quantity)
            return false;
        if (sellCost != other.sellCost)
            return false;
        if (eachItemtotalValue != other.eachItemtotalValue)
            return false;
        if (customerName != other.customerName)
            return false;
        return true;
    }

    public Billing() {
    }

    public Billing(String item, int quantity, int sellCost, int eachItemtotalValue, String customerName) {
        this.item = item;
        this.quantity = quantity;
        this.sellCost = sellCost;
        this.eachItemtotalValue = eachItemtotalValue;
        this.customerName = customerName;
    }

    public void setItem(String item) {
        this.item = item;
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

    public int getEachItemtotalValue() {
        return eachItemtotalValue;
    }

    public void setEachItemtotalValue(int eachItemtotalValue) {
        this.eachItemtotalValue = eachItemtotalValue;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    int quantity;
    int sellCost;
    int eachItemtotalValue;
    String customerName;
}
