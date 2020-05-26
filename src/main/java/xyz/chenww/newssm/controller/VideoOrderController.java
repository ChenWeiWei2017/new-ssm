package xyz.chenww.newssm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.chenww.newssm.utils.JsonData;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/5/25
 */
@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {

    @GetMapping("save")
    public JsonData save() {
        return JsonData.buildSuccess("下单成功！");
    }
}
