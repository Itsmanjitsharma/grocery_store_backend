package com.grocerystore.store;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryStoreRepository extends JpaRepository<StoreInventoryDAO, Long> {

    
    
    List<StoreInventoryDAO> findByItemNameIn(List<String> itemNameList);

    @Modifying
    @Query("UPDATE StoreInventoryDAO e SET e.quantity = ?2 WHERE e.itemName = ?1 ")
    int updateQuantityByItemName(String itemName,BigDecimal quantity);

    @Modifying
    @Query("DELETE FROM StoreInventoryDAO WHERE itemName = :itemName")
    void deleteByItemName(@Param("itemName") String itemName);

    @Query("SELECT e FROM StoreInventoryDAO e WHERE itemName = ?1")
    Optional<StoreInventoryDAO> findByItemName(String product);

}