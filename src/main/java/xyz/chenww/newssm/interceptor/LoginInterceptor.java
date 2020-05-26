package xyz.chenww.newssm.interceptor;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xyz.chenww.newssm.domain.User;
import xyz.chenww.newssm.service.impl.UserServiceImpl;
import xyz.chenww.newssm.utils.JsonData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 功能描述：自定义登录请求拦截器
 *
 * @author chenweiwei
 * @since 2020/5/26
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor-preHandle");
        // 处理登录验证逻辑
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        if (!StringUtils.isEmpty(token)) {
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null) {
                return true;
            } else {
                JsonData jsonData = JsonData.buildByStatus(JsonData.Status.INVALID_LOGIN_STATUS);
                renderJson(response, JSON.toJSONString(jsonData));
                return false;
            }
        } else {
            JsonData jsonData = JsonData.buildByStatus(JsonData.Status.NOT_LOGIN);
            renderJson(response, JSON.toJSONString(jsonData));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor-postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor-afterCompletion");
    }

    private void renderJson(HttpServletResponse response, String json) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = response.getWriter()){
            writer.write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
