package vn.techmaster.websitenoithat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.websitenoithat.entity.Customer;
import vn.techmaster.websitenoithat.repository.CustomerRepository;

import java.util.Collection;

@Service
public class CustomerServiceIpml implements CustomerService {

    @Autowired private CustomerRepository customerRepository ;

    @Override
    public Collection<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
