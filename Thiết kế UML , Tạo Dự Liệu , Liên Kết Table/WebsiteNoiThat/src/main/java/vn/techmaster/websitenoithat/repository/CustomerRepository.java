package vn.techmaster.websitenoithat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.websitenoithat.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , String> {
}
