package com.grocerystore.store;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillingTransactionDTO {
    public BillingTransactionDTO() {
    }

    @Override
    public String toString() {
        return "BillingTransactionDTO [id=" + id + ", customerName=" + customerName + ", paymentMethod=" + paymentMethod
                + ", paymentStatus=" + paymentStatus + ", billing_date=" + billing_date + ", totalBill=" + totalBill
                + ", billingType="+ billingType +"]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
        result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
        result = prime * result + ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
        result = prime * result + ((billing_date == null) ? 0 : billing_date.hashCode());
        result = prime * result + ((totalBill == null) ? 0 : totalBill.hashCode());
        result = prime * result + ((billingType == null) ? 0 : billingType.hashCode());
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
        BillingTransactionDTO other = (BillingTransactionDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (customerName == null) {
            if (other.customerName != null)
                return false;
        } else if (!customerName.equals(other.customerName))
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
        if (billing_date == null) {
            if (other.billing_date != null)
                return false;
        } else if (!billing_date.equals(other.billing_date))
            return false;
        if (totalBill == null) {
            if (other.totalBill != null)
                return false;
        } else if (!totalBill.equals(other.totalBill))
            return false;
        if (billingType == null) {
            if (other.billingType != null)
                return false;
        } else if (!billingType.equals(other.billingType))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public LocalDate getBilling_date() {
        return billing_date;
    }

    public void setBilling_date(LocalDate billing_date) {
        this.billing_date = billing_date;
    }

    public BigDecimal getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(BigDecimal totalBill) {
        this.totalBill = totalBill;
    }

    Long id;
    String customerName;
    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    String paymentMethod;
    String paymentStatus;
    LocalDate billing_date;
    BigDecimal totalBill;
    String billingType;
  
    public BillingTransactionDTO(Long id, String customerName, String paymentMethod, String paymentStatus,
            LocalDate billing_date,BigDecimal totalBill,String billingType) {
                this.id = id;
                this.customerName = customerName;
                this.paymentMethod = paymentMethod;
                this.paymentStatus = paymentStatus;
                this.billing_date = billing_date;
                this.totalBill = totalBill;
                this.billingType = billingType;
    }

}
