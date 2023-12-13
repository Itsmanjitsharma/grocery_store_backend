package com.grocerystore.store;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ProductDetailsDTO
 */
@Data
@ToString
@NoArgsConstructor
public class ProductDetailsDTO {

    private String product;
    
    private BigDecimal purchaseCost;
    
    private BigDecimal quantity;
    private String partyName;
    private LocalDate purchasDate;
    private BigDecimal sellCost;
    private BigDecimal wholesaleCost;
    public ProductDetailsDTO(String product, BigDecimal purchaseCost, BigDecimal quantity, String partyName, LocalDate purchasDate,
            BigDecimal sellCost, BigDecimal wholesaleCost) {
        this.product = product;
        this.purchaseCost = purchaseCost;
        this.quantity = quantity;
        this.partyName = partyName;
        this.purchasDate = purchasDate;
        this.sellCost = sellCost;
        this.wholesaleCost = wholesaleCost;
    }
}