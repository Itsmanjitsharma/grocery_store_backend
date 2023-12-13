package com.grocerystore.store;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfoDAO {
   private String product;
   private BigDecimal quantity;
   private BigDecimal sell_cost;
   private BigDecimal total_cost;
   private String payment_status;
   private String payment_method;
   private LocalDate bill_date; 
}
