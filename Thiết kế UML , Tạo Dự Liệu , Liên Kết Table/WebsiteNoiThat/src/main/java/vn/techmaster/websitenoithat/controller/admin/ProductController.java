package vn.techmaster.websitenoithat.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.websitenoithat.entity.Product;
import vn.techmaster.websitenoithat.service.ProductServiceIpml;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceIpml productServiceIpml ;

    @GetMapping
    public Collection<Product> getAllProduct () {
        return productServiceIpml.getAllProduct();
    }
}
