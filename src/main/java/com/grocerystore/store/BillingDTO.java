package com.grocerystore.store;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BillingDTO {
    String product;
    BigDecimal quantity;
    BigDecimal sellCost;
    BigDecimal totalCost;
    BigDecimal quantityInStock;
}
