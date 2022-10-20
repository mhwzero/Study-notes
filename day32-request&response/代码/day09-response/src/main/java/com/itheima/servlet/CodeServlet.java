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
        //1. 生成一张验证码图片对象
        LineCaptcha lineCaptcha = new LineCaptcha(300, 100);
        System.out.println("验证码的数字:" + lineCaptcha.getCode());

        //2. 将图片以字节流的形式返回到浏览器
        lineCaptcha.write(resp.getOutputStream());
    }
}
