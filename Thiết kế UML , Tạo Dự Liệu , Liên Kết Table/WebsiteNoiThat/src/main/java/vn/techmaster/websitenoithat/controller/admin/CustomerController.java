package vn.techmaster.websitenoithat.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.websitenoithat.entity.Customer;
import vn.techmaster.websitenoithat.service.CustomerServiceIpml;

import java.util.Collection;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired private CustomerServiceIpml customerServiceIpml ;

    @GetMapping
    public Collection<Customer> getAllCustomer () {
        return customerServiceIpml.getAllCustomer() ;
    }
}
