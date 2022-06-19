package vn.techmaster.websitenoithat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Customer")
@Table(name = "customer")
public class Customer implements Serializable {
    @GenericGenerator(name = "random_id", strategy = "vn.techmaster.websitenoithat.model.RandomIdGenerator")
    @Id
    @GeneratedValue(generator = "random_id")
    private String id;

    @Column(name = "avatars")
    private String avatars ;

    @Column(name = "name", columnDefinition = "nvarchar(50)")
    private String name;

    @Column(name = "email", columnDefinition = "nvarchar(100) ")
    private String email;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "phone", length = 12)
    private String phone;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updated_at;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;

    // Liên kết 1 cus - n order
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Orders> orders = new ArrayList<>();

    //TODO liên kết với bảng role 1 - n customer
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private Role role;

    // Liên kết cus - cart 1 -1
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void add(Orders orderss) {
        orderss.setCustomer(this);
        orders.add(orderss);
    }

    public void setCart(Cart cart) {
        cart.setCustomer(this);
        this.cart = cart;
    }
}
