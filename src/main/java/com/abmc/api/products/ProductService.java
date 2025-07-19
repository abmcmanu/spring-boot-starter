package com.abmc.api.products;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ProductService {

    private final ObjectMapper objectMapper;

    public ProductService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Product> loadProducts() {
        try {
            ClassPathResource resource = new ClassPathResource("bouchons/products.json");
            InputStream inputStream = resource.getInputStream();

            return objectMapper.readValue(inputStream, new TypeReference<List<Product>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du chargement des produits JSON", e);
        }
    }

}
