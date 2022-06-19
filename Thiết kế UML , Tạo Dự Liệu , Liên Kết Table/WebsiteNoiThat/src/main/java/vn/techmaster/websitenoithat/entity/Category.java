package vn.techmaster.websitenoithat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Category")
@Table(name = "category")
public class Category implements Serializable {
    @GenericGenerator(name = "random_id", strategy = "vn.techmaster.websitenoithat.model.RandomIdGenerator")
    @Id @GeneratedValue(generator="random_id")
    private String id ;

    @Column (name = "name" )
    private String name ;

    @Column (name = "code" )
    private String code ;

    // Liên kết 1 categpoy - n product
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = false )
    @JoinColumn(name = "category_id")
    private List<Product> products = new ArrayList<>();


    public Category(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void add (Product product) {
        product.setCategory(this);
        products.add(product);
    }

}