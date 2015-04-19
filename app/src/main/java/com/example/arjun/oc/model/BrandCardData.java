package com.example.arjun.oc.model;

/**
 * Created by Kushal on 18-04-2015.
 */
public class BrandCardData {

    private String brandName, brandImageUrl;
    private int brandDiscount;

    public BrandCardData(String brandName, int brandDiscount, String brandImageUrl) {
        this.brandName = brandName;
        this.brandDiscount = brandDiscount;
        this.brandImageUrl = brandImageUrl;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getBrandDiscount() {
        return brandDiscount;
    }

    public void setBrandDiscount(int brandDiscount) {
        this.brandDiscount = brandDiscount;
    }

    public String getBrandImageUrl() {
        return brandImageUrl;
    }

    public void setBrandImageUrl(String brandImageUrl) {
        this.brandImageUrl = brandImageUrl;
    }
}
