package vn.techmaster.websitenoithat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Cart")
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
    @GenericGenerator(name = "random_id", strategy = "vn.techmaster.websitenoithat.model.RandomIdGenerator")
    @Id
    @GeneratedValue(generator="random_id")
    private String id ;

    @OneToOne(mappedBy = "cart")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = false )
    @JoinColumn(name = "cart_id")
    private List<Cart_Product> cart_products = new ArrayList<>();

    @Column(nullable = false)
    @Enumerated
    private Status status;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    public Cart(Customer customer, Status status) {
        this.customer = customer;
        this.status = status;
    }

    public void add (Cart_Product cart_product) {
        cart_product.setCart(this);
        cart_products.add(cart_product);
    }

}
