package vn.techmaster.websitenoithat.service;

import vn.techmaster.websitenoithat.dto.ProductDTO;
import vn.techmaster.websitenoithat.entity.Category;
import vn.techmaster.websitenoithat.entity.Product;

import java.util.Collection;

public interface ProductService {
    public Collection<Product> getAllProduct() ;
    public Product addProduct(Product product) ;
    public void generatorProduct () ;

}
