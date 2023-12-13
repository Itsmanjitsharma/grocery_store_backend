package com.grocerystore.store;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "store_inventry") // Specify the table name if different from the class name
public class StoreInventry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Item", length = 255)
    private String item;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "Purchage_Cost")
    private BigDecimal purchaseCost;

    @Column(name = "Sell_Cost")
    private BigDecimal sellCost;

    @Column(name = "wholesale_Cost")
    private BigDecimal wholesaleCost;

    @Column(name = "Stock_Value")
    private BigDecimal stockValue;

    @Column(name = "Party_Name", length = 250)
    private String partyName;

    @Column(name = "Purchage_Date")
    private Date purchaseDate;
}
