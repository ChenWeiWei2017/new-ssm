package xyz.chenww.newssm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.chenww.newssm.domain.User;
import xyz.chenww.newssm.service.UserService;
import xyz.chenww.newssm.utils.JsonData;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/5/22
 */
@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public JsonData login(@RequestBody User user) {
        String token = userService.login(user);
        return token != null ? JsonData.buildSuccess(token) : JsonData.buildByStatus(JsonData.Status.LOGIN_FAILED, "用户名或密码错误");
    }


}
