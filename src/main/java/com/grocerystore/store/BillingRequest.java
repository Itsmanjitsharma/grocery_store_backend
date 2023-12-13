package com.grocerystore.store;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BillingRequest {
    
    @Override
    public String toString() {
        return "BillingRequest [rows=" + rows + ", totalBill=" + totalBill + ", paymentMethod=" + paymentMethod
                + ", paymentStatus=" + paymentStatus + ", customerName=" + customerName + ", billingType=" + billingType
                + ", billingDate=" + billingDate + "]";
    }
    public BillingRequest() {
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rows == null) ? 0 : rows.hashCode());
        result = prime * result + ((totalBill == null) ? 0 : totalBill.hashCode());
        result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
        result = prime * result + ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
        result = prime * result + ((billingType == null) ? 0 : billingType.hashCode());
        result = prime * result + ((billingDate == null) ? 0 : billingDate.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BillingRequest other = (BillingRequest) obj;
        if (rows == null) {
            if (other.rows != null)
                return false;
        } else if (!rows.equals(other.rows))
            return false;
        if (totalBill == null) {
            if (other.totalBill != null)
                return false;
        } else if (!totalBill.equals(other.totalBill))
            return false;
        if (paymentMethod == null) {
            if (other.paymentMethod != null)
                return false;
        } else if (!paymentMethod.equals(other.paymentMethod))
            return false;
        if (paymentStatus == null) {
            if (other.paymentStatus != null)
                return false;
        } else if (!paymentStatus.equals(other.paymentStatus))
            return false;
        if (customerName == null) {
            if (other.customerName != null)
                return false;
        } else if (!customerName.equals(other.customerName))
            return false;
        if (billingType == null) {
            if (other.billingType != null)
                return false;
        } else if (!billingType.equals(other.billingType))
            return false;
        if (billingDate == null) {
            if (other.billingDate != null)
                return false;
        } else if (!billingDate.equals(other.billingDate))
            return false;
        return true;
    }
    public BillingRequest(List<BillingDTO> rows, BigDecimal totalBill, String paymentMethod, String paymentStatus,
            String customerName, String billingType, LocalDate billingDate) {
        this.rows = rows;
        this.totalBill = totalBill;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.customerName = customerName;
        this.billingType = billingType;
        this.billingDate = billingDate;
    }
    public List<BillingDTO> getRows() {
        return rows;
    }
    public void setRows(List<BillingDTO> rows) {
        this.rows = rows;
    }
    public BigDecimal getTotalBill() {
        return totalBill;
    }
    public void setTotalBill(BigDecimal totalBill) {
        this.totalBill = totalBill;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getBillingType() {
        return billingType;
    }
    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }
    public LocalDate getBillingDate() {
        return billingDate;
    }
    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }
    List<BillingDTO> rows;
    BigDecimal totalBill;
    String paymentMethod;
    String paymentStatus;
    String customerName;
    String billingType;
    LocalDate billingDate;
}
