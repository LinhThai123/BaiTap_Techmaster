package vn.techmaster.websitenoithat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.websitenoithat.dto.ProductDTO;
import vn.techmaster.websitenoithat.entity.Order_detail;
import vn.techmaster.websitenoithat.entity.Product;
import vn.techmaster.websitenoithat.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Service
public class ProductServiceIpml implements ProductService{

    @PersistenceContext
    private EntityManager em;

    @Autowired private ProductRepository productRepository ;

    @Override
    public Collection<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void generatorProduct() {

    }
}
