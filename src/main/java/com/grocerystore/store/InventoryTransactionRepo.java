package com.grocerystore.store;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryTransactionRepo extends JpaRepository<InventryTransactionDAO,Long>{

    @Query(name = "SELECT it FROM INVENTORYTRANSACTIONDAO it WHERE it.itemName =:searchTerm")
    List<InventryTransactionDAO> findByItemName(@Param("searchTerm") String searchTerm);
    
}
