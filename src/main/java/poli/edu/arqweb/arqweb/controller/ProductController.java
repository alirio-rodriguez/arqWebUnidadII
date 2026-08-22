package poli.edu.arqweb.arqweb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poli.edu.arqweb.arqweb.model.Product;
import poli.edu.arqweb.arqweb.service.ProductService;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product createdProduct = productService.saveProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable String id) {
        Product deletedProduct = productService.deleteProductById(id);
        if (deletedProduct != null) {
            return ResponseEntity.ok(deletedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
