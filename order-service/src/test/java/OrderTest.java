import com.app.OrderApp;
import com.entities.Order;
import com.entities.OrderStatusEnum;
import com.repositories.OrderDao;
import com.services.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = OrderApp.class)
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderService orderService;


    @Test
    public void orderTest() {
        Order order = new Order(1l);
        OrderStatusEnum orderStatusEnum = orderService.calcStatus(order.getUserId());
        order.setStatusEnumId(orderStatusEnum);
        order.getProductIds().add(1l);
        order.getProductIds().add(2l);
        Order save = orderDao.save(order);
        System.out.println(save.toString());

    }

}