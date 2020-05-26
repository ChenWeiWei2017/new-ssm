package xyz.chenww.newssm.filter;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import xyz.chenww.newssm.domain.User;
import xyz.chenww.newssm.service.impl.UserServiceImpl;
import xyz.chenww.newssm.utils.JsonData;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 功能描述：请求过滤器
 *
 * @author chenweiwei
 * @since 2020/5/25
 */
//和LoginInterceptor功能一致，这里注掉
//@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    /**
     * 容器加载初始化时调用
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=========Filter Init=========");
    }

    /**
     * 执行过滤操作
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("=========DoFilter=========");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        if (StringUtils.isEmpty(token)) {
            JsonData jsonData = JsonData.buildByStatus(JsonData.Status.NOT_LOGIN);
            renderJson(response, JSON.toJSONString(jsonData));
            return;
        }

        User user = UserServiceImpl.sessionMap.get(token);
        if (user != null) {
            // token校验成功
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            JsonData jsonData = JsonData.buildByStatus(JsonData.Status.INVALID_LOGIN_STATUS);
            renderJson(response, JSON.toJSONString(jsonData));
        }

    }

    /**
     * 容器销毁时调用
     */
    @Override
    public void destroy() {
        System.out.println("=========Filter Destroy=========");
    }

    private void renderJson(HttpServletResponse response, String json) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        try(PrintWriter writer = response.getWriter()) {
            writer.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
