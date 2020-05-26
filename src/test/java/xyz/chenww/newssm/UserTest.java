package xyz.chenww.newssm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.chenww.newssm.controller.UserController;
import xyz.chenww.newssm.domain.User;
import xyz.chenww.newssm.utils.JsonData;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/5/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserController userController;

    @Test
    public void loginTest() throws JsonProcessingException {
        User user = new User();
        user.setUsername("chenww");
        user.setPassword("123456");

        JsonData jsonData = userController.login(user);

        System.out.println(new ObjectMapper().writeValueAsString(jsonData));

        // 断言
        Assert.assertEquals(0, jsonData.getCode());
    }
}
