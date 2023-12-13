package com.grocerystore.store;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DashboardDetails {
    private BigDecimal sale;
    private long customer;
    private long products;
    private double profit;
    private List<PaymentData> paymentData;
    private List<InventoryData> inventoryData;
    private List<SaleData> saleData;
}
