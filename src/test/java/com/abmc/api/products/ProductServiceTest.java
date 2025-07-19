package com.abmc.api.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.support.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {


    @Autowired
    private ProductService productService;  // injection Spring

    private List<Product> products;


    @BeforeEach
    void setUp() {
        products = productService.loadProducts();
    }

    @Test
    void testLoadProducts() {
        assertNotNull(products, "La liste ne doit pas être nulle, fichier chargé correctement");
        assertFalse(products.isEmpty(), "La liste ne doit pas être vide, fichier chargé correctement");
    }

    @Test
    void testFistProduct() {
        Product product = products.get(0);
        assertEquals("p001",product.getId(), "L'id du produit ne doit pas être nul");
        assertNotNull(product.getName(), "Le nom du produit ne doit pas être nul");
        assertNotNull(product.getImages(), "La liste des images ne doit pas être nulle");
        assertFalse(product.getImages().isEmpty(), "Le produit doit avoir au moins une image");
    }

    @Test
    void testLoadProductsFromResource_ThrowsRuntimeException() throws IOException {
        // Mock de la ressource qui lance une IOException à l'ouverture du stream
        Resource mockResource = mock(Resource.class);
        when(mockResource.getInputStream()).thenThrow(new IOException("Fichier introuvable"));

        ObjectMapper objectMapper = new ObjectMapper();
        ProductService productService = new ProductService(objectMapper);

        RuntimeException exception = assertThrows(RuntimeException.class, productService::loadProducts);

        assertTrue(exception.getMessage().contains("Erreur lors du chargement"));
        assertInstanceOf(IOException.class, exception.getCause());
    }
}