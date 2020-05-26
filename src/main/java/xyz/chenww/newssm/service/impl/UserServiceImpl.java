package xyz.chenww.newssm.service.impl;

import org.springframework.stereotype.Service;
import xyz.chenww.newssm.domain.User;
import xyz.chenww.newssm.mapper.UserMapper;
import xyz.chenww.newssm.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/5/22
 */
@Service
public class UserServiceImpl implements UserService {

    // 模拟session-token
    public static Map<String, User> sessionMap = new HashMap<>();

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String login(String username, String password) {
        User user = userMapper.findUserByName(username);
        if (user != null && Objects.equals(user.getPassword(), password)) {
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            sessionMap.put(token, user);
            return token;
        }
        return null;
    }

    @Override
    public String login(User user) {
        return this.login(user.getUsername(), user.getPassword());
    }
}
