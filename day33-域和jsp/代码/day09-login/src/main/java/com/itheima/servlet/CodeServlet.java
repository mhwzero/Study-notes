package com.itheima.servlet;

import cn.hutool.captcha.LineCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/codeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 生成验证码
        LineCaptcha captcha = new LineCaptcha(100, 40);
        String code = captcha.getCode();
        System.out.println("生成的验证码是:"+code);

        //2. 将验证码保存到session中
        req.getSession().setAttribute("code",code);

        //3. 将验证码以字节流的形式写回浏览器
        captcha.write(resp.getOutputStream());
    }
}
