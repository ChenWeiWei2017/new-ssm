package xyz.chenww.newssm.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.chenww.newssm.NewSsmApplication;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/5/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {NewSsmApplication.class})// 启动整个SpringBoot工程
public class ServiceTest {

    @Before
    public void testBefore() {
        System.out.println("Service Test Before.");
    }

    @After
    public void testAfter() {
        System.out.println("Service Test After.");
    }

    @Test
    public void test() {
        System.out.println("Service Test ...");
    }
}
