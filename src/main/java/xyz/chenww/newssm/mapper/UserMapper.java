package xyz.chenww.newssm.mapper;

import org.springframework.stereotype.Repository;
import xyz.chenww.newssm.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/5/21
 */
@Repository
public class UserMapper {

    // 模拟用户数据
    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("chenww", new User(1, "chenww", "123456"));
        userMap.put("xdclass", new User(2, "xdclass", "abcdef"));
        userMap.put("tom", new User(3, "tom", "123abc"));
    }

    public User findUserByName(String username) {
        return userMap.get(username);
    }
}
