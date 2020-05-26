package xyz.chenww.newssm.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.chenww.newssm.utils.JsonData;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：全局异常处理器
 * 处理程序中不可知（没有预料到）的异常
 *
 * @author chenweiwei
 * @since 2020/5/25
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    JsonData handlerException(Exception e, HttpServletRequest request) {
        // 处理异常
        String errorMessage = e.getMessage();
        String uri = request.getRequestURI();
        logger.error("程序运行出现未知异常，错误信息：[{}]，访问地址：[{}]", errorMessage, uri);
        return JsonData.buildError("服务器出错了");
    }
}
