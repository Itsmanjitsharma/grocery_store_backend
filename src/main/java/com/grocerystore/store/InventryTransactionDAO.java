package com.grocerystore.store;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@NoArgsConstructor
@Table(name = "stock_transactions")
public class InventryTransactionDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(nullable = false,name = "item_name")
    private String itemName;

    @Column(nullable = false,name = "quantity")
    private BigDecimal quantity;

    @Column(nullable = false, precision = 10, scale = 2,name = "purchase_cost")
    private BigDecimal purchaseCost;

    @Column(nullable = false, precision = 10, scale = 2,name = "sell_cost")
    private BigDecimal sellCost;

    @Column(nullable = false, precision = 10, scale = 2,name = "wholesale_cost")
    private BigDecimal wholesaleCost;

    @Column(nullable = false, precision = 10, scale = 2,name = "stock_value")
    private BigDecimal stockValue;

    @Column(nullable = false,name = "party_name")
    private String partyName;

    @Column(nullable = false,name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(nullable = false,name = "unit_type")
    private String unitType;

    public InventryTransactionDAO(String itemName, BigDecimal quantity, BigDecimal purchaseCost, BigDecimal sellCost, BigDecimal wholesaleCost ,BigDecimal stockValue, String partyName, LocalDate purchaseDate,String unitType) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.purchaseCost = purchaseCost;
        this.sellCost = sellCost;
        this.wholesaleCost = wholesaleCost;
        this.stockValue = stockValue;
        this.partyName = partyName;
        this.purchaseDate = purchaseDate;
        this.unitType = unitType;
    }    
}
