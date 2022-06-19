package vn.techmaster.websitenoithat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.websitenoithat.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
