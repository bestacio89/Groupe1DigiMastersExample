package Groupe1DigiMasters.example;

import Model.Product;
import Service.ProductService;
import Service.ProductServiceImpl;
import Util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();

        try {
            // Create a new product
            Product product = new Product();
            product.setName("Product A");
            product.setDescription("Description A");
            productService.save(product);

            // Retrieve all products
            productService.findAll().forEach(p -> System.out.println(p.getName()));

            // Retrieve a product by ID
            Product retrievedProduct = productService.findById(1L).orElse(null);
            if (retrievedProduct != null) {
                System.out.println("Retrieved Product: " + retrievedProduct.getName());
            }

            // Delete a product by ID
            productService.deleteById(1L);

        } catch (IllegalArgumentException e) {
            System.err.println("Validation error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Shutdown Hibernate
            HibernateUtil.shutdown();
        }
    }
}