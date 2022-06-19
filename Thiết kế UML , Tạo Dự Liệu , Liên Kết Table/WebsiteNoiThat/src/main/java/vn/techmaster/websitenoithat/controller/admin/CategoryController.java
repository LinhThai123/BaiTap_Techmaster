package vn.techmaster.websitenoithat.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.websitenoithat.entity.Category;
import vn.techmaster.websitenoithat.service.CategoryServiceIpml;

import java.util.Collection;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired private CategoryServiceIpml categoryServiceIpml ;

    @GetMapping
    public Collection<Category> getAllCategory() {
        return categoryServiceIpml.getAllCategory();
    }
}
