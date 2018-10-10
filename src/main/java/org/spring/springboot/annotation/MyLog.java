package org.spring.springboot.annotation;

import java.lang.annotation.*;

/**
 * 本文件的作用是什么?
 * 本文件的作用是:定义 MyLog 自定义注解
 * @author sam
 * @since 2017/7/13
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyLog {

    String requestUrl();

}