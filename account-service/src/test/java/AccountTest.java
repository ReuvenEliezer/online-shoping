import com.app.AccountApp;
import com.entities.Account;
import com.entities.User;
import com.repositories.UserDao;
import com.usils.WsAddressConstants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = AccountApp.class)
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserDao userDao;


    @Test
    public void accountTest() {
        Account account = new Account("account-name-1");
        Account accountSaved = restTemplate.postForObject(WsAddressConstants.accountFullUrl + "createAccount", account, Account.class);
        Assert.assertNotNull(accountSaved);

        User user1 = new User("account-name-1", accountSaved);
        User user1Saved = restTemplate.postForObject(WsAddressConstants.userFullUrl + "createUser", user1, User.class);
        Assert.assertNotNull(user1Saved);

        User user2 = new User("account-name-2", accountSaved);
        User user2Saved = restTemplate.postForObject(WsAddressConstants.userFullUrl + "createUser", user2, User.class);
        Assert.assertNotNull(user2Saved);

        List<User> usersByAccountId = userDao.getByAccountId(accountSaved.getId());
        Assert.assertEquals(2,usersByAccountId.size());
    }

}