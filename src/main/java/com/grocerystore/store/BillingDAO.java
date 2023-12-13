package com.grocerystore.store;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

@Entity
@Table(name = "Billing")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BillingDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "sell_cost")
    private BigDecimal sellCost;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name = "bill_date")
    private LocalDate date;

    @Column(name = "billing_transaction_id")
    private Long billing_transaction_id;
}
