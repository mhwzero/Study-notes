package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.itheima")
@EnableAspectJAutoProxy //激活切面自动代理
public class SpringConfig {
}
