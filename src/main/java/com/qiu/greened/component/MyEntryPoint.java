package com.qiu.greened.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiu.greened.pojo.vo.ResultVo;
import com.qiu.greened.utils.ResultCode;
import com.qiu.greened.utils.ResultGenerator;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 提示前端认证错误
        ObjectMapper mapper = new ObjectMapper();
        ResultVo<Object> result = ResultGenerator.result(ResultCode.UNAUTHORIZED);
        out.write(mapper.writeValueAsString(result));
        out.flush();
        out.close();
    }
}
