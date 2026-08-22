package poli.edu.arqweb.arqweb.service;

import org.springframework.stereotype.Service;
import poli.edu.arqweb.arqweb.model.Product;
import poli.edu.arqweb.arqweb.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(String id){
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product deleteProductById(String id){
        Product product = productRepository.findById(id).orElse(null);
        if (product != null){
            productRepository.deleteById(id);
            return product;
        }
        return null;
    }

    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setNombre(product.getNombre());
            existingProduct.setDescripcion(product.getDescripcion());
            existingProduct.setPrecio(product.getPrecio());
            return productRepository.save(existingProduct);
        }
        return null;
    }

}
