package com.adminportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Guitar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String model;
    private String company;
    private String category;
    private double listPrice;
    private double ourPrice;
    private double shippingWeight;
    private boolean active = true;

    @Column(columnDefinition = "text")
    private String description;

    private int inStockNumber;
    @Transient
    private MultipartFile guitarImage;

    @OneToMany(mappedBy= "guitar")
    @JsonIgnore
    private List<GuitarToCartItem> guitarToCartItemList;

    public List<GuitarToCartItem> getGuitarToCartItemList() {
        return guitarToCartItemList;
    }

    public void setGuitarToCartItemList(List<GuitarToCartItem> guitarToCartItemList) {
        this.guitarToCartItemList = guitarToCartItemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String type) {
        this.category = type;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInStockNumber() {
        return inStockNumber;
    }

    public void setInStockNumber(int inStockNo) {
        this.inStockNumber = inStockNo;
    }

    public MultipartFile getGuitarImage() {
        return guitarImage;
    }

    public void setGuitarImage(MultipartFile guitarImage) {
        this.guitarImage = guitarImage;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }
}
