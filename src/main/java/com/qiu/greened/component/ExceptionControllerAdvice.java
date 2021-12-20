package com.qiu.greened.component;

import com.qiu.greened.pojo.vo.ResultVo;
import com.qiu.greened.utils.ResultCode;
import com.qiu.greened.utils.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ApiException.class)
    public ResultVo<Object> apiExceptionHandler(ApiException e) {
        return ResultGenerator.result(e.getResultCode(), e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return ResultGenerator.result(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultVo<Object> exceptionHandler(Exception e) {
        log.warn(e.toString());
        return ResultGenerator.result(ResultCode.FAILED);
    }
}