package xyz.chenww.newssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 功能描述：MockMvc测试
 * MockMvc相当于一个客户端，可以发送Http请求，去访问Api接口
 * MockMvc会与druidWebStatFilter数据库连接池请求过滤器冲突
 *
 * @author chenweiwei
 * @since 2020/5/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // 开启MockMvc客户端
public class VideoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVideoListApi() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        response.setCharacterEncoding("UTF-8");

        int status = response.getStatus();
        System.out.println(status);

        //String content = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        String content = response.getContentAsString();
        System.out.println(content);
    }
}
