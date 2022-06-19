package vn.techmaster.websitenoithat.service;

import vn.techmaster.websitenoithat.dto.CategoryDTO;
import vn.techmaster.websitenoithat.entity.Category;
import vn.techmaster.websitenoithat.request.CategoryRequest;

import java.util.Collection;

public interface CategoryService {
    public Collection<Category> getAllCategory() ;
    public Collection<Category> findById (String id ) ;
    public Category addCategory(Category category) ;
    public  Category updateCategory(Category category) ;
    public String deleteCategory (String id) ;
    public void generatorCategory() ;
}
