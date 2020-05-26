package xyz.chenww.newssm.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 功能描述：应用上下文监听器
 * 监听应用上下文创建及销毁，需要实现 ServletContextListener 接口
 *
 *
 * @author chenweiwei
 * @since 2020/5/26
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("==============应用上下文初始化==============");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("==============应用上下文销毁==============");
    }
}
