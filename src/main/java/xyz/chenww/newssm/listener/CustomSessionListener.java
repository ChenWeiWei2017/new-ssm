package xyz.chenww.newssm.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 功能描述：自定义会话监听器
 *
 * @author chenweiwei
 * @since 2020/5/26
 */
@WebListener
public class CustomSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("+++++++++++++会话创建+++++++++++++");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("+++++++++++++会话销毁+++++++++++++");
    }
}
