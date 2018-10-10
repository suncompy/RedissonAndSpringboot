package org.spring.springboot.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 本文件作用是什么?
 * 本文件的作用是: 定义要切进去的切面
 * @author sam
 * @since 2017/7/13
 */
@Aspect //AOP 切面
@Component
public class MyLogAspect {


    
    @Pointcut(value = "@annotation(org.spring.springboot.annotation.MyLog)")
    // @Pointcut 的作用是什么?
    // @Pointcut 的作用是:指定切入点(即自定义的注解)
    private void pointcut() {

    }
    // pointcut() 的作用是什么?
    // pointcut() 的作用是:代替切入点
    


    /**
     * 在方法执行前后
     *
     * @param point
     * @param myLog
     * @return
     */
    @Around(value = "pointcut() && @annotation(myLog)")
    // @Around 和 pointcut() 的联系是什么?
    public Object around(ProceedingJoinPoint point, MyLog myLog) {

        System.out.println("++++执行了around方法++++");

        String requestUrl = myLog.requestUrl();

        //拦截的类名
        Class clazz = point.getTarget().getClass();
        //拦截的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();

        System.out.println("执行了 类:" + clazz + " 方法:" + method + " 自定义请求地址:" + requestUrl);

        try {
            return point.proceed(); //执行程序
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return throwable.getMessage();
        }
    }

    /**
     * 方法执行后
     *
     * @param joinPoint
     * @param myLog
     * @param result
     * @return
     */
    @AfterReturning(value = "pointcut() && @annotation(myLog)", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, MyLog myLog, Object result) {

//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();

        System.out.println("++++执行了afterReturning方法++++");

        System.out.println("执行结果：" + result);
        // result 是什么?作用是什么?
        // result 是 被切的函数返回的结果.这里也就是 IndexController.index() 返回的结果

        return result;
    }

    /**
     * 方法执行后 并抛出异常
     *
     * @param joinPoint
     * @param myLog
     * @param ex
     */
    @AfterThrowing(value = "pointcut() && @annotation(myLog)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, MyLog myLog, Exception ex) {
        System.out.println("++++执行了afterThrowing方法++++");
        System.out.println("请求：" + myLog.requestUrl() + " 出现异常");
    }

}