package xyz.chenww.newssm.service;

import xyz.chenww.newssm.domain.User;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/5/22
 */
public interface UserService {

    String login(String username, String password);

    String login(User user);
}
