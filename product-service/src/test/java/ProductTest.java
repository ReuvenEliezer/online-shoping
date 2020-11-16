import com.app.ProductApp;
import com.entities.Product;
import com.repositories.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = ProductApp.class)
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductDao productDao;


    @Test
    public void productTest() {
        Product product = new Product("product-name-1", 2d);

    }

}