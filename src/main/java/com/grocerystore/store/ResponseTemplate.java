package com.grocerystore.store;

import java.math.BigDecimal;

public class ResponseTemplate {
    int xAxix;
    public ResponseTemplate(int xAxix, BigDecimal yAxix) {
        this.xAxix = xAxix;
        this.yAxix = yAxix;
    }
    @Override
    public String toString() {
        return "ResponseTemplate [xAxix=" + xAxix + ", yAxix=" + yAxix + "]";
    }
    public int getxAxix() {
        return xAxix;
    }
    public void setxAxix(int xAxix) {
        this.xAxix = xAxix;
    }
    public BigDecimal getyAxix() {
        return yAxix;
    }
    public void setyAxix(BigDecimal yAxix) {
        this.yAxix = yAxix;
    }
    BigDecimal yAxix;

}
