package com.grocerystore.store;

import java.util.List;

public class ProductReponseDTO {

    @Override
    public String toString() {
        return "ProductReponseDTO [quantityData=" + quantityData + ", priceData=" + priceData + ", products=" + products
                + "]";
    }
    public List<ResponseTemplate> getQuantityData() {
        return quantityData;
    }
    public void setQuantityData(List<ResponseTemplate> quantityData) {
        this.quantityData = quantityData;
    }
    public List<ResponseTemplate> getPriceData() {
        return priceData;
    }
    public void setPriceData(List<ResponseTemplate> priceData) {
        this.priceData = priceData;
    }
    public List<ProductDetailsDTO> getProducts() {
        return products;
    }
    public void setProducts(List<ProductDetailsDTO> products) {
        this.products = products;
    }
    List<ResponseTemplate> quantityData;
    List<ResponseTemplate> priceData;
    List<ProductDetailsDTO> products;
    

}
