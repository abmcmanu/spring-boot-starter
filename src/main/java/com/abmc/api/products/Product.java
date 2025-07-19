package com.abmc.api.products;

import java.util.List;

public class Product {
    private String id;
    private String name;
    private String description;
    private List<String> images;
    private String mainImage;

    public Product() {}

    public Product(String id, String name, String description, List<String> images, String mainImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.mainImage = mainImage;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }

    public String getMainImage() { return mainImage; }
    public void setMainImage(String mainImage) { this.mainImage = mainImage; }
}
