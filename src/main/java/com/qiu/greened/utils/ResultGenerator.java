package com.qiu.greened.utils;


import com.qiu.greened.pojo.vo.ResultVo;

public class ResultGenerator {

    public static ResultVo<Object> result(ResultCode resultCode) {
        ResultVo<Object> result = new ResultVo<>();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        return result;
    }

    public static ResultVo<Object> result(ResultCode resultCode, String msg) {
        ResultVo<Object> result = new ResultVo<>();
        result.setCode(resultCode.getCode());
        result.setMsg(msg);
        return result;
    }

    /**
     * 成功处理请求
     */
    public static ResultVo<Object> success() {
        return new ResultVo<>(ResultCode.SUCCESS);
    }

    public static ResultVo<Object> success(String msg) {
        ResultVo<Object> result = new ResultVo<>(ResultCode.SUCCESS);
        result.setMsg(msg);
        return result;
    }

    public static <T> ResultVo<T> success(T data) {
        ResultVo<T> result = new ResultVo<>(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> ResultVo<T> success(String msg, T data) {
        ResultVo<T> result = new ResultVo<>(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 请求失败
     */
    public static ResultVo<Object> failed() {
        return new ResultVo<>(ResultCode.FAILED);
    }

    public static ResultVo<Object> failed(String message) {
        ResultVo<Object> result = new ResultVo<>(ResultCode.FAILED);
        result.setMsg(message);
        return result;
    }
}
