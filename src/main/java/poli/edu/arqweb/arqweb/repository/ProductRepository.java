package poli.edu.arqweb.arqweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poli.edu.arqweb.arqweb.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
