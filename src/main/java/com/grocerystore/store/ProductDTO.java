package com.grocerystore.store;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {   
    private String product;
    private BigDecimal sellCost;
    private BigDecimal wholesaleCost;
    private BigDecimal quantityInStock;
}
