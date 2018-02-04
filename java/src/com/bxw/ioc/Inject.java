package com.bxw.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指定需要注入的属性
 * 只要被@Inject注解注释的属性都会自动注入，实现IOC功能
 * Created by wxb on 2018/2/4.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

}
