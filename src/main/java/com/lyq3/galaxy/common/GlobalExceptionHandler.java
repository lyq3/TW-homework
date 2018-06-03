package com.lyq3.galaxy.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局的权限验证和异常拦截
 * @author Lyq
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger  =  LoggerFactory.getLogger(GlobalExceptionHandler. class );

    /**
     * 业务异常
     */
    @ExceptionHandler(BussinessException.class)
    @ResponseBody
    public Result<String> bussinessException(BussinessException e) {
        // 输出JSON
        Result<String> res = new Result<String>();
        res.setCode(e.getCode()).setMsg(e.getMsg());
        return res;
    }

    /**
     * 404异常
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public  String notFoundException(NoHandlerFoundException e){
        return "redirect:/index.html";
    }
    /**
     * 其他未知异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> bussinessException(Exception e) {
        e.printStackTrace();
        // 输出JSON
        Result<String> res = new Result<String>();
        res.setCode(999).setMsg("未知异常，请检查文本格式");
        return res;
    }
}
