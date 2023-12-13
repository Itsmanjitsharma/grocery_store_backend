package com.grocerystore.store;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingTransactionRepo extends JpaRepository<BillingTransactionDAO,Long> {
@Query("SELECT b FROM BillingTransactionDAO b WHERE b.billing_date BETWEEN :startDate AND :endDate")
    List<BillingTransactionDAO> findAllByBillingDateBetween(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );
}
