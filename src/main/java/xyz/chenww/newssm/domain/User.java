package xyz.chenww.newssm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 功能描述：用户实体类
 *
 * @author chenweiwei
 * @since 2020/5/21
 */
public class User {

    private Integer id;

    private String username;

//    @JsonIgnore
    private String password;

    public User() {}

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
