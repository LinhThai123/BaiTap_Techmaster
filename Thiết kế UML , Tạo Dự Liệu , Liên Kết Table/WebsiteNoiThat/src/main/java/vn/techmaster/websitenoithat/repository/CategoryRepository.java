package vn.techmaster.websitenoithat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.websitenoithat.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category , String> {
}
