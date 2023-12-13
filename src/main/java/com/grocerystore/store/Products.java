package com.grocerystore.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
    @Column(name = "item")
    String item;

    @Column(name = "price")
    double price;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + quantity;
        result = prime * result + productId;
        return result;
    }

    public Products(String item, double price, int quantity, int productId) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Products [item=" + item + ", price=" + price + ", quantity=" + quantity + ", productId=" + productId
                + "]";
    }

    public Products() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Products other = (Products) obj;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (quantity != other.quantity)
            return false;
        if (productId != other.productId)
            return false;
        return true;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
