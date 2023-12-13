package com.grocerystore.store;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroceryService {

    @Autowired
    GroceryStoreRepository groceryStoreRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    BillingRepository billingRepository;

    @Autowired
    InventoryTransactionRepo inventoryTransactionRepo;

    @Autowired
    BillingTransactionRepo billingTransactionRepo;

    @Autowired
    CustomerRepository customerRepository;

    public void saveStock(List<StoreInventry> inventryList) throws IOException {
        Map<String, StoreInventoryDAO> uiMap = new HashMap<String, StoreInventoryDAO>();
        for (StoreInventry storeInventry : inventryList) {
            if (!uiMap.containsKey(storeInventry.getItem())) {
                uiMap.put(storeInventry.getItem(), new StoreInventoryDAO(storeInventry.getItem(),
                        storeInventry.getQuantity(), storeInventry.getPurchaseCost(), storeInventry.getSellCost(),
                        storeInventry.getWholesaleCost()));
            }
        }
        Map<String, StoreInventoryDAO> dbMap = groceryStoreRepository.findByItemNameIn(new ArrayList<>(uiMap.keySet()))
                .stream()
                .collect(Collectors.toMap(StoreInventoryDAO::getItemName, Function.identity()));
        List<StoreInventoryDAO> inventoryDAOsToSave = new ArrayList<>();
        for (String itemName : uiMap.keySet()) {
            StoreInventoryDAO storeInventoryDAOUI = uiMap.get(itemName);
            if (dbMap.containsKey(itemName)) {
                StoreInventoryDAO storeInventoryDAODB = dbMap.get(itemName);
                storeInventoryDAODB
                        .setQuantity(storeInventoryDAOUI.getQuantity().add(storeInventoryDAODB.getQuantity()));
                storeInventoryDAODB.setPurchaseCost(storeInventoryDAOUI.getPurchaseCost());
                storeInventoryDAODB.setSellCost(storeInventoryDAOUI.getSellCost());
                storeInventoryDAODB.setWholesaleCost(storeInventoryDAOUI.getWholesaleCost());
                inventoryDAOsToSave.add(storeInventoryDAODB);
            } else {
                inventoryDAOsToSave.add(storeInventoryDAOUI);
            }
        }
        groceryStoreRepository.saveAll(inventoryDAOsToSave);
        saveInventoryTransaction(inventryList);
    }

    public void saveInventoryTransaction(List<StoreInventry> inventryList) {
        List<InventryTransactionDAO> inventryTransactionDAOList = new ArrayList<>();
        for (StoreInventry storeInventry : inventryList) {
            inventryTransactionDAOList.add(new InventryTransactionDAO(
                    storeInventry.getItem(),
                    storeInventry.getQuantity(),
                    storeInventry.getPurchaseCost(),
                    storeInventry.getSellCost(),
                    storeInventry.getWholesaleCost(),
                    storeInventry.getStockValue(),
                    storeInventry.getPartyName(),
                    LocalDate.now()));
        }
        inventoryTransactionRepo.saveAll(inventryTransactionDAOList);
    }

    public List<InventryTransactionDAO> getAllInventoryTransaction() {
        List<InventryTransactionDAO> inventorySummery = inventoryTransactionRepo.findAll();
        return inventorySummery;
    }

    public void saveProducts(List<Products> productsTosave) {
        List<Products> productsInDatabase = productsRepository.findAll();
        Map<String, Products> productMap = new HashMap<String, Products>();
        for (Products products : productsInDatabase) {
            if (!productMap.containsKey(products.getItem())) {
                productMap.put(products.getItem(), products);
            }
        }
        int i = 0;
        List<Products> filteredProducts = new ArrayList<Products>();
        while (i < productsTosave.size()) {
            Products product = new Products();
            if (productMap.containsKey(productsTosave.get(i).getItem())) {
                Products productFromDatabase = productMap.get(productsTosave.get(i).getItem());
                product.setItem(productFromDatabase.getItem());
                product.setPrice(productsTosave.get(i).getPrice());
                product.setQuantity(productsTosave.get(i).getQuantity() + productFromDatabase.getQuantity());
                product.setProductId(productFromDatabase.getProductId());
                filteredProducts.add(new Products());
            } else {
                product = productsTosave.get(i);
            }
            filteredProducts.add(product);
            i++;
        }
        productsRepository.saveAll(filteredProducts);
    }

    public List<StoreInventoryDAO> getAllProducts() {
        return groceryStoreRepository.findAll();
    }

    public void saveBillingInfo(BillingRequest billingRequest) {
        List<BillingDTO> billingDTOList = billingRequest.getRows();
        List<BillingDAO> billingDAOList = new ArrayList<BillingDAO>();
        BillingTransactionDAO billingTransactionDAO = new BillingTransactionDAO(billingRequest.getTotalBill(),
                billingRequest.getPaymentMethod(), billingRequest.getPaymentStatus(), billingRequest.getCustomerName(),
                LocalDate.now(), billingRequest.billingType);
        BillingTransactionDAO billingTransactionDB = billingTransactionRepo.save(billingTransactionDAO);
        for (BillingDTO billingDTO : billingDTOList) {
            BillingDAO billingDAO = new BillingDAO();
            billingDAO.setProduct(billingDTO.getProduct());
            billingDAO.setQuantity(billingDTO.getQuantity());
            billingDAO.setSellCost(billingDTO.getSellCost());
            billingDAO.setTotalCost(billingDTO.getTotalCost());
            billingDAO.setDate(LocalDate.now());
            billingDAO.setBilling_transaction_id(billingTransactionDB.getId());
            billingDAOList.add(billingDAO);
        }
        billingRepository.saveAll(billingDAOList);
        maintainInventory(billingDTOList);
    }

    public void maintainInventory(List<BillingDTO> billingDTOList) {
        for (BillingDTO billingDTO : billingDTOList) {
            groceryStoreRepository.updateQuantityByItemName(billingDTO.getProduct(), billingDTO.getQuantityInStock());
        }
    }

    public List<BillingTransactionDTO> getBillinInfo(String startDate, String endDate) {
        System.out.println("service");
        System.out.println(startDate);
        System.out.println(endDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the string into a LocalDate
        LocalDate localDateStart = LocalDate.parse(startDate, formatter);
        LocalDate localDateEnd = LocalDate.parse(endDate, formatter);

        List<BillingTransactionDAO> billingTransactionDAOList = billingTransactionRepo
                .findAllByBillingDateBetween(localDateStart, localDateEnd);
        System.out.println(billingTransactionDAOList);
        List<BillingTransactionDTO> billingTransactionDTOs = new ArrayList<>();
        for (BillingTransactionDAO billingTransactionDAO : billingTransactionDAOList) {
            billingTransactionDTOs.add(new BillingTransactionDTO(billingTransactionDAO.getId(),
                    billingTransactionDAO.getCustomerName(), billingTransactionDAO.getPaymentMethod(),
                    billingTransactionDAO.getPaymentStatus(), billingTransactionDAO.getBilling_date(),
                    billingTransactionDAO.getTotalBill(), billingTransactionDAO.getBillingType()));
        }
        return billingTransactionDTOs;
    }

    public List<StoreInventoryDAO> getInventryInfo() {
        return groceryStoreRepository.findAll();
    }

    public List<InventryTransactionDAO> getItemSummeryInfo(String searchTerm) {
        return inventoryTransactionRepo.findByItemName(searchTerm);
    }

    public void deleteProductFromStoreInventory(String itemName) {
        groceryStoreRepository.deleteByItemName(itemName);
    }

    public void updateRowInStoreInventory(UpdatedRowData updatedRowData) {
        try {
            // Validation and error handling can be added here

            // Create a StoreInventoryDAO object with the updated data
            StoreInventoryDAO storeInventoryDAO = new StoreInventoryDAO(
                    updatedRowData.getProduct(),
                    updatedRowData.getQuantity(),
                    updatedRowData.getPurchaseCost(),
                    updatedRowData.getSellCost(),
                    updatedRowData.getWholesaleCost());
            // Find the existing record to update (usually based on the ID)
            Optional<StoreInventoryDAO> existingRecord = groceryStoreRepository
                    .findByItemName(updatedRowData.getProduct());
            if (existingRecord.isPresent()) {
                // Update the existing record with the new data
                StoreInventoryDAO updatedRecord = existingRecord.get();
                updatedRecord.setItemName(storeInventoryDAO.getItemName());
                updatedRecord.setQuantity(storeInventoryDAO.getQuantity());
                updatedRecord.setPurchaseCost(storeInventoryDAO.getPurchaseCost());
                updatedRecord.setSellCost(storeInventoryDAO.getSellCost());
                updatedRecord.setWholesaleCost(storeInventoryDAO.getWholesaleCost());

                // Save the updated record to the database
                groceryStoreRepository.save(updatedRecord);

            } else {
                return;
            }
        } catch (Exception e) {
            return;
        }
    }

    public ProductReponseDTO getProductsDetails(String productName) {
        List<InventryTransactionDAO> inventryTransactionDAOs = inventoryTransactionRepo.findByItemName(productName);
        ProductReponseDTO productReponseDTOs = new ProductReponseDTO();
        List<ResponseTemplate> priceList = new ArrayList<ResponseTemplate>();
        List<ResponseTemplate> quantityList = new ArrayList<ResponseTemplate>();
        List<ProductDetailsDTO> products = new ArrayList<ProductDetailsDTO>();
        int i = 1;
        for (InventryTransactionDAO inventryTransactionDAO : inventryTransactionDAOs) {
            priceList.add(new ResponseTemplate(i++, inventryTransactionDAO.getPurchaseCost()));
            quantityList.add(new ResponseTemplate(i++, inventryTransactionDAO.getQuantity()));
            products.add(new ProductDetailsDTO(inventryTransactionDAO.getItemName(),
                    inventryTransactionDAO.getPurchaseCost(), inventryTransactionDAO.getQuantity(),
                    inventryTransactionDAO.getPartyName(), inventryTransactionDAO.getPurchaseDate(),
                    inventryTransactionDAO.getSellCost(), inventryTransactionDAO.getWholesaleCost()));
        }
        productReponseDTOs.setPriceData(priceList);
        productReponseDTOs.setQuantityData(quantityList);
        productReponseDTOs.setProducts(products);
        return productReponseDTOs;
    }

    public List<CustomerInfoDAO> getCustomerInfoDAOs(String customerName) {
        List<CustomerInfoDAO> infoDAOs = new ArrayList<>();
        List<Object[]> resultset = billingRepository.findByCustomerName(customerName);
        for (Object[] object : resultset) {
            CustomerInfoDAO infoDAO = new CustomerInfoDAO();
            infoDAO.setProduct((String) object[1]);
            infoDAO.setQuantity((BigDecimal) object[2]);
            infoDAO.setSell_cost((BigDecimal) object[3]);
            infoDAO.setTotal_cost((BigDecimal) object[4]);
            infoDAO.setPayment_status((String) object[5]);
            infoDAO.setPayment_method((String) object[6]);
            infoDAO.setBill_date((LocalDate) object[0]); // Assuming object[0] is a java.sql.Date

            // Adding mapped CustomerInfoDAO to the list
            infoDAOs.add(infoDAO);
        }
        return infoDAOs;
    }

    public DashboardDetails getDashboardDetails() {
        DashboardDetails dashboardDetails = new DashboardDetails();
        dashboardDetails.setCustomer(customerRepository.count());
        dashboardDetails.setProducts(groceryStoreRepository.count());
        dashboardDetails.setProfit(0);
        List<BillingTransactionDAO> billingTransactionDAOList = billingTransactionRepo.findAll();
        BigDecimal total = billingTransactionDAOList.stream()
                .map(BillingTransactionDAO::getTotalBill)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        dashboardDetails.setSale(total);
        Map<String, Double> totalBillByPaymentMethod = billingTransactionDAOList.stream()
                .collect(Collectors.groupingBy(
                        BillingTransactionDAO::getPaymentMethod,
                        Collectors.summingDouble(transaction -> transaction.getTotalBill().doubleValue())));

        Map<LocalDate, Double> sales = billingTransactionDAOList.stream()
                .collect(Collectors.groupingBy(
                        BillingTransactionDAO::getBilling_date,
                        Collectors.summingDouble(transaction -> transaction.getTotalBill().doubleValue())));
        List<PaymentData> paymentDatas = new ArrayList<>();
        totalBillByPaymentMethod.entrySet().stream().forEach(action -> {
            paymentDatas.add(new PaymentData(action.getKey(), action.getValue()));
        });
        dashboardDetails.setPaymentData(paymentDatas);

        List<StoreInventoryDAO> storeInventoryDAOs = groceryStoreRepository.findAll();
        Map<String, Long> itemCountsByCategory = storeInventoryDAOs.stream()
                .collect(Collectors.groupingBy(item -> {
                    BigDecimal quantity = item.getQuantity();
                    if (quantity.compareTo(BigDecimal.valueOf(5)) > 0) {
                        return "In Stock";
                    } else if (quantity.compareTo(BigDecimal.ZERO) > 0) {
                        return "Going to Out of Stock";
                    } else {
                        return "Out of Stock";
                    }
                }, Collectors.counting()));

        List<InventoryData> inventoryDatas = new ArrayList<>();
        itemCountsByCategory.entrySet().stream().forEach(action -> {
            inventoryDatas.add(new InventoryData(action.getKey(), action.getValue()));
        });

        List<SaleData> saleDatas = new ArrayList<>();
        sales.entrySet().stream().forEach(action -> {
            LocalDate localDate = ((LocalDate) action.getKey());
            SaleData data = new SaleData(localDate.getDayOfMonth() + "/" + localDate.getMonthValue(),
                    action.getValue());
            saleDatas.add(data);
        });
        dashboardDetails.setSaleData(saleDatas);
        dashboardDetails.setInventoryData(inventoryDatas);
        System.out.println(dashboardDetails);
        return dashboardDetails;
    }
}