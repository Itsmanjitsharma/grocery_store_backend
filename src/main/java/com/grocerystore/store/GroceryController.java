package com.grocerystore.store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://62.72.57.113:5173")
public class GroceryController {
    @Autowired
    GroceryService groceryService;

    @PostMapping("/addInventory")
    public void saveStock(@RequestBody InventryDTO inventryList) {
        List<StoreInventry> inventoryItemList = new ArrayList<StoreInventry>();
        int i = 0;
        InventryDTO action = inventryList;
        long id = action.hashCode();
        StoreInventry inventoryItem = new StoreInventry(id, action.getProduct().trim(), action.getQuantity(),
                action.getPurchaseCost(),
                action.getSellCost(), action.getWholesaleCost(),
                action.getQuantity().multiply(action.getPurchaseCost()),
                action.getPartyName(), new Date());
        inventoryItemList.add(i, inventoryItem);
        try {
            groceryService.saveStock(inventoryItemList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/dashboardDetails")
    public DashboardDetails getDashboardDetails(){
            return groceryService.getDashboardDetails();
    }
    @GetMapping("/getProducts")
    public List<ProductDTO> getProducts() {
        List<StoreInventoryDAO> productlist = groceryService.getAllProducts();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (StoreInventoryDAO storeInventoryDAO : productlist) {
            ProductDTO productDTO = new ProductDTO(
                    storeInventoryDAO.getItemName(),
                    storeInventoryDAO.getSellCost(),
                    storeInventoryDAO.getWholesaleCost(),
                    storeInventoryDAO.getQuantity());
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    @GetMapping("product/{productName}")
    public ProductReponseDTO getProductDetails(@PathVariable String productName) {
        return groceryService.getProductsDetails(productName);
    }

    @PostMapping("/billing")
    public void saveBillingInfo(@RequestBody BillingRequest billingRequests) {
        groceryService.saveBillingInfo(billingRequests);
    }

    @GetMapping("/getBillingInfo")
    public List<BillingTransactionDTO> getBillingInfos(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        System.out.println(startDate);
        System.out.println(endDate);
        List<BillingTransactionDTO> billingInfoList = new ArrayList<BillingTransactionDTO>();
        startDate = startDate.split("T")[0];
        endDate = endDate.split("T")[0];
        if (!startDate.isEmpty() && !endDate.isEmpty()) {
            billingInfoList = groceryService.getBillinInfo(startDate, endDate);
        }
        return billingInfoList;
    }

    @GetMapping("/CustomerInfo/{customerName}")
    public List<CustomerInfoDAO> getCustomerInfoDAOs(@PathVariable String customerName) {
        return groceryService.getCustomerInfoDAOs(customerName);
    }

    @GetMapping("/getInventeryInfo")
    public List<StoreInventoryDTO> getInventryInfo() {
        List<StoreInventoryDTO> inventoryDTOs = new ArrayList<StoreInventoryDTO>();
        List<StoreInventoryDAO> inventryInfoList = new ArrayList<StoreInventoryDAO>();
        inventryInfoList = groceryService.getInventryInfo();
        Long i = 1L;
        for (StoreInventoryDAO storeInventoryDAO : inventryInfoList) {
            inventoryDTOs.add(new StoreInventoryDTO(i++, storeInventoryDAO.getItemName(),
                    storeInventoryDAO.getQuantity(), storeInventoryDAO.getPurchaseCost(),
                    storeInventoryDAO.getSellCost(), storeInventoryDAO.getWholesaleCost()));
        }
        return inventoryDTOs;
    }

    @GetMapping("/getInventerySummeryInfo")
    public List<InventorySummeryDTO> getInventerySummeryInfo() {
        List<InventryTransactionDAO> inventrySummeryInfoList = new ArrayList<InventryTransactionDAO>();
        List<InventorySummeryDTO> inventorySummery = new ArrayList<InventorySummeryDTO>();
        inventrySummeryInfoList = groceryService.getAllInventoryTransaction();
        for (InventryTransactionDAO inventryTransactionDAO : inventrySummeryInfoList) {
            inventorySummery.add(new InventorySummeryDTO(inventryTransactionDAO.getTransactionId(),
                    inventryTransactionDAO.getItemName(), inventryTransactionDAO.getQuantity(),
                    inventryTransactionDAO.getSellCost(), inventryTransactionDAO.getPurchaseCost(),
                    inventryTransactionDAO.getWholesaleCost(), inventryTransactionDAO.getStockValue(),
                    inventryTransactionDAO.getPartyName(), inventryTransactionDAO.getPurchaseDate()));
        }
        return inventorySummery;
    }

    @DeleteMapping("/deleteRow/{productName}")
    public void deleteRow(@PathVariable String productName) {
        groceryService.deleteProductFromStoreInventory(productName);
    }

    @PutMapping("/updateRow")
    public void updateRow(@RequestBody UpdatedRowData updatedRowData) {
        groceryService.updateRowInStoreInventory(updatedRowData);
    }

    @GetMapping("/getItemSummeryInfo")
    public List<InventryTransactionDAO> getItemSummeryInfo(@RequestParam(name = "search") String searchTerm) {
        List<InventryTransactionDAO> inventrySummeryInfoList = groceryService.getItemSummeryInfo(searchTerm);
        return inventrySummeryInfoList;
    }
}
