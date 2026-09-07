package poli.edu.arqweb.arqweb.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import poli.edu.arqweb.arqweb.model.Product;
import poli.edu.arqweb.arqweb.service.ProductService;

import java.util.List;

@Controller
public class ProductGraphQLController {

    private final ProductService productService;

    public ProductGraphQLController(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public List<Product> products() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public Product productById(@Argument String id) {
        return productService.getProductById(id);
    }

    @MutationMapping
    public Product createProduct(@Argument("input") Product product) {
        return productService.saveProduct(product);
    }

    @MutationMapping
    public Product updateProduct(@Argument("input") Product product) {
        return productService.updateProduct(product);
    }

    @MutationMapping
    public Product deleteProduct(@Argument String id) {
        return productService.deleteProductById(id);
    }
}
