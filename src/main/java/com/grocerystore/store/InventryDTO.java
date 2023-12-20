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
public class InventryDTO {
    String product;
    BigDecimal quantity;
    BigDecimal purchaseCost;
    BigDecimal sellCost;
    String partyName;
    BigDecimal stockValue;
    BigDecimal wholesaleCost;    
    BigDecimal minimumQuantity =BigDecimal.valueOf(0);
    String unitType;
    
}
