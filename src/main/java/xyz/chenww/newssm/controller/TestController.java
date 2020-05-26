package xyz.chenww.newssm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.chenww.newssm.utils.JsonData;

/**
 * 功能描述：测试接口
 *
 * @author chenweiwei
 * @since 2020/5/25
 */
@RestController
@RequestMapping("api/v1/test")
public class TestController {

    // 全局异常捕捉处理测试
    @GetMapping("list")
    public JsonData list() {
        // 抛出异常
        int i = 1/0;
        return JsonData.buildSuccess("");
    }
}
