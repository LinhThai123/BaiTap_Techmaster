package vn.techmaster.websitenoithat.entity;

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
@Entity(name = "Role")
@Table (name = "Role")
public class Role implements Serializable {
    @GenericGenerator(name = "random_id", strategy = "vn.techmaster.websitenoithat.model.RandomIdGenerator")
    @Id @GeneratedValue(generator="random_id")
    private String id ;

    @Column(name = "name" , columnDefinition = "varchar(50)")
    private String name ;

    // Liên kết 1 role - n cus
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL , orphanRemoval = true )
    @JsonManagedReference
    private List<Customer> customers = new ArrayList<>();
}
