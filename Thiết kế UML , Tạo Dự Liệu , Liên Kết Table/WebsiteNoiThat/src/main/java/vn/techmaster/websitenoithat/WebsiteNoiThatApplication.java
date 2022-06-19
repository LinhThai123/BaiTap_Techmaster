package vn.techmaster.websitenoithat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import vn.techmaster.websitenoithat.entity.*;
import vn.techmaster.websitenoithat.model.RandomIdGenerator;
import vn.techmaster.websitenoithat.model.RandomString;
import vn.techmaster.websitenoithat.repository.CategoryRepository;
import vn.techmaster.websitenoithat.repository.ProductRepository;
import vn.techmaster.websitenoithat.service.CategoryServiceIpml;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class WebsiteNoiThatApplication implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    @Autowired private CategoryServiceIpml categoryServiceIpml;

    public static void main(String[] args) {
        SpringApplication.run(WebsiteNoiThatApplication.class, args);
    }

    public void generator() {

        String code = UUID.randomUUID().toString();
        Category category1 = new Category("Bàn" , code) ;
        Category category2 = new Category("Ghế" , code) ;
        Category category3 = new Category("Sofa" , code);


        Customer cus1 = new Customer("Bod" , "123");
        Customer cus2 = new Customer("Tom" , "123");
        Customer cus3 = new Customer("Alice" , "123");


        Product p1 = new Product("Bàn SuteBlack" , 5 , 2.200 , category1 ) ;
        Product p2 = new Product("Ghế 4Color" , 4 , 3.4400 , category2 ) ;
        Product p3 = new Product("Sofa CLC" , 6 , 1.000 , category3 ) ;

        Galery ga1 = new Galery("ban.png" , p1) ;
        Galery ga2 = new Galery("ghe.png" , p2) ;
        Galery ga3 = new Galery("sofa.png" , p3) ;

        Cart cart1 = new Cart(cus1 , Status.CONHANG) ;
        Cart cart2 = new Cart(cus2 , Status.HETHANG) ;
        Cart cart3 = new Cart(cus3 , Status.CONHANG) ;


        Cart_Product cart_product1 = new Cart_Product(cart1 , p1) ;
        Cart_Product cart_product2 = new Cart_Product(cart2 , p2) ;
        Cart_Product cart_product3 = new Cart_Product(cart3 , p3) ;

        Orders orders1 = new Orders("bob@gmail.com" , "0966351634" , "Nghệ An " , cus1) ;
        Orders orders2 = new Orders("alice@gmail.com" , "0966351635" , "Hà Nội" , cus3) ;
        Orders orders3 = new Orders("tom@gmail.com" , "0966351636" , "Hải Phòng",cus2) ;

        Order_detail order_detail1 = new Order_detail(50000, 5 , 40000 , p1 , orders1);
        Order_detail order_detail2 = new Order_detail(40000, 5 , 30000 , p2 , orders2);
        Order_detail order_detail3 = new Order_detail(60000, 5 , 60000 , p3 , orders3);

        // category product
        category1.add(p1);
        category2.add(p2);
        category3.add(p3);

        em.persist(category1);
        em.persist(category2);
        em.persist(category3);

        // cus orders
        cus1.add(orders1);
        cus2.add(orders3);
        cus3.add(orders2);

        em.persist(cus1);
        em.persist(cus3);
        em.persist(cus2);

        // order_detail product
        p1.add(order_detail1);
        p2.add(order_detail2);
        p3.add(order_detail3);

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        // orders order_detail
        orders1.add(order_detail1);
        orders2.add(order_detail2);
        orders3.add(order_detail3);

        em.persist(orders1);
        em.persist(orders2);
        em.persist(orders3);

        // galery product
        p1.add(ga1);
        p2.add(ga2);
        p3.add(ga3);

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        // cart cart_product
        cart1.add(cart_product1);
        cart2.add(cart_product2);
        cart3.add(cart_product3);

        em.persist(cart1);
        em.persist(cart2);
        em.persist(cart3);

        // product cart_product
        p1.add(cart_product1);
        p2.add(cart_product2);
        p3.add(cart_product3);

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.flush();
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        generator();
    }
}
