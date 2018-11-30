/*
 * 文件名：JWTAccessDeniedHandler.java
 * 版权：Copyright 2000-2009 Huawei Tech. Co. Ltd. All Rights Reserved. 
 * 描述： TopEng-CSP V600R003 广东移动客户服务平台NGCCⅡ期
 * 修改人： 周乐生
 * 修改时间：2018年11月30日
 * 修改内容：新增 
 * 修改人： 
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package cn.echisan.springbootjwtdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author  周乐生
 * @since   2018年11月30日
 */
public class JWTAccessDeniedHandler implements AccessDeniedHandler
{

    /* (non-Javadoc)
     * @see org.springframework.security.web.access.AccessDeniedHandler#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.access.AccessDeniedException)
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException)
            throws IOException, ServletException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        String reason = "访问权限统一处理，原因："+accessDeniedException.getMessage();
        response.getWriter().write(new ObjectMapper().writeValueAsString(reason));
        
    }
    
}
