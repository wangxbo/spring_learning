package com.bxw.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指定需要容器管理的类
 * 只要被@Component自定义主键注释的类都是受容器管理里的bean
 * Created by wxb on 2018/2/4.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
}
