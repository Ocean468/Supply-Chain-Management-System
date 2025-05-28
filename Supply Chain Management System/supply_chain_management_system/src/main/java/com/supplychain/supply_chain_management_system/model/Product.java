package com.supplychain.supply_chain_management_system.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private double price;

    private int quantity;

    private String description;

    private String warranty;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    private AppUser farmer;

    // Constructors
    public Product() {}

    public Product(String name, String category, double price, int quantity, String description, AppUser farmer) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.farmer = farmer;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public AppUser getFarmer() { return farmer; }

    public void setFarmer(AppUser farmer) { this.farmer = farmer; }

    public String getWarranty() {
        return warranty;
    }
    
    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
    
}

