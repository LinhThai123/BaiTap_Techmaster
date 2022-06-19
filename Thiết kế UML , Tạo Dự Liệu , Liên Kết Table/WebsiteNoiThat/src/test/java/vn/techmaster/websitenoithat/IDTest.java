package vn.techmaster.websitenoithat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import vn.techmaster.websitenoithat.entity.Category;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@DataJpaTest

public class IDTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @AutoConfigureTestDatabase
    void randomIDGenerator() {
        Category category = new Category();
        category.setName("Elephant");
        category.setCode("H1");
        String id = (String) testEntityManager.persistAndGetId(category);

        assertThat(id).hasSizeGreaterThanOrEqualTo(10);
    }
}
