package vn.techmaster.websitenoithat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.websitenoithat.entity.Category;
import vn.techmaster.websitenoithat.entity.Product;
import vn.techmaster.websitenoithat.repository.CategoryRepository;
import vn.techmaster.websitenoithat.request.CategoryRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.UUID;

@Service
public class CategoryServiceIpml implements CategoryService {

    @PersistenceContext
    private EntityManager em;

    @Autowired private CategoryRepository categoryRepository ;

    @Override
    public Collection<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Collection<Category> findById(String id) {
        return null;
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public String deleteCategory(String id) {
        return null;
    }

    @Override
    public void generatorCategory() {

    }
}
