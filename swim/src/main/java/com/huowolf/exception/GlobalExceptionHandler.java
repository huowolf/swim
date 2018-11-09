package com.huowolf.exception;

/**
 * Created by huowolf on 2018/11/6.
 */
import com.baomidou.kaptcha.exception.KaptchaException;
import com.baomidou.kaptcha.exception.KaptchaIncorrectException;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import com.baomidou.kaptcha.exception.KaptchaTimeoutException;
import com.huowolf.util.Result;
import com.huowolf.util.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = KaptchaException.class)
    public Result kaptchaExceptionHandler(KaptchaException kaptchaException) {

        if (kaptchaException instanceof KaptchaIncorrectException) {
            return ResultUtil.error("验证码不正确");
        } else if (kaptchaException instanceof KaptchaNotFoundException) {
            return ResultUtil.error("验证码未找到");
        } else if (kaptchaException instanceof KaptchaTimeoutException) {
            return ResultUtil.error("验证码过期");
        } else {
            return ResultUtil.error("验证码渲染失败");
        }

    }

}