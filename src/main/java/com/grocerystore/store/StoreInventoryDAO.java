package com.grocerystore.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Data
@Entity
@NoArgsConstructor
@Table(name = "store_inventory")
public class StoreInventoryDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , name="item_name")
    private String itemName;

    @Column(nullable = false, name="quantity")
    private BigDecimal quantity;
    
    @Column(nullable = false, name="purchase_cost")
    private BigDecimal purchaseCost;

    @Column(nullable = false,name = "sell_cost")
    private BigDecimal sellCost;

    public StoreInventoryDAO(String itemName, BigDecimal quantity, BigDecimal purchaseCost, BigDecimal sellCost,
            BigDecimal wholesaleCost, String unitType, BigDecimal minimumQuantity) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.purchaseCost = purchaseCost;
        this.sellCost = sellCost;
        this.wholesaleCost = wholesaleCost;
        this.unitType = unitType;
        this.minimumQuantity = minimumQuantity;
    }

    @Column(nullable = false,name = "wholesale_cost")
    private BigDecimal wholesaleCost;

    @Column(nullable = false , name = "unit_type")
    private String unitType;

    @Column(nullable = false, name = "minimum_quantity")
    private BigDecimal minimumQuantity;

    
}
