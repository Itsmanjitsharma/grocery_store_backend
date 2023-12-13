package com.grocerystore.store;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UpdatedRowData {
    private Long id; // The ID of the row to update
    private String product; // Updated product name
    private BigDecimal quantity; // Updated quantity
    private BigDecimal purchaseCost;
    private BigDecimal sellCost;
    private BigDecimal wholesaleCost;
    @JsonCreator
    public UpdatedRowData(
        @JsonProperty("id") Long id,
        @JsonProperty("product") String product,
        @JsonProperty("quantity") BigDecimal quantity,
        @JsonProperty("purchaseCost") BigDecimal purchaseCost,
        @JsonProperty("sellCost") BigDecimal sellCost,
        @JsonProperty("wholesaleCost") BigDecimal wholesaleCost) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.purchaseCost = purchaseCost;
        this.sellCost = sellCost;
        this.wholesaleCost = wholesaleCost;
    }

}