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
public class StoreInventoryDTO {
    private Long id;
    private String product;
    private BigDecimal quantity;
    private BigDecimal purchaseCost;
    private BigDecimal sellCost;
    private BigDecimal wholesaleCost;
    private String unitType;
}
