package com.grocerystore.store;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<BillingDAO, Long> {

    /*@Query("SELECT b.billDate, b.product, b.quantity, b.sellCost, b.totalCost, bt.paymentStatus, bt.paymentMethod " +
           "FROM Billing b INNER JOIN BillingTransaction bt ON bt.id = b.billingTransactionId " +
           "WHERE bt.customerName = :customerName")
    List<Object[]> findByCustomerName(@Param("customerName") String customerName);*/

    @Query("SELECT b.date, b.product, b.quantity, b.sellCost, b.totalCost, bt.paymentStatus, bt.paymentMethod " +
       "FROM BillingDAO b INNER JOIN BillingTransactionDAO bt ON bt.id = b.billing_transaction_id " +
       "WHERE bt.customerName = :customerName")
List<Object[]> findByCustomerName(@Param("customerName") String customerName);


}
