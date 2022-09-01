package com.itheima.p5_override_notice;
/*
    方法重写的注意事项
        1. 子类方法覆盖父类方法，必须要保证权限大于等于父类权限。
            权限:
                public > protected > 默认(什么都不写) > private

        2. 子类方法覆盖父类方法，
            返回值类型、函数名和参数列表都要一模一样。
            必要条件:
                函数名和参数列表都要一模一样
            可选条件:
                返回值类型可以不一样
            子类覆盖重写后的方法的返回值类型 <= 父类方法返回值类型

        3. 私有方法不能被重写(父类私有成员子类是不能继承的)
*/
public class Demo05OverrideNotice {
}
