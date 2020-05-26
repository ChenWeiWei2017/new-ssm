package xyz.chenww.newssm.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 功能描述：自定义请求监听器
 * 每一个请求都会被监听
 *
 * @author chenweiwei
 * @since 2020/5/26
 */
@WebListener
public class CustomRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("*************请求销毁*************");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("*************请求创建*************");
    }
}
