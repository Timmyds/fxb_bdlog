
package com.fxb.blog.business.aspect;

import com.fxb.blog.business.annotation.BussinessLog;
import com.fxb.blog.framework.holder.RequestHolder;
import com.fxb.blog.util.IpUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * AOP切面记录日志
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Aspect
@Component
public class BussinessLogAspect {

    private static final String PARAM_SEPARTOR = " & ";

    private static final Logger LOGGER = LoggerFactory.getLogger(BussinessLogAspect.class);

    @Pointcut(value = "@annotation(com.fxb.blog.business.annotation.BussinessLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object writeLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            LOGGER.error("日志记录出错!", e);
        }

        return result;
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) throws Throwable {
        LOGGER.error("捕获到了异常...", ex);
    }

    private void handle(ProceedingJoinPoint point) throws Exception {
        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        //获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();
        //获取操作名称
        BussinessLog annotation = currentMethod.getAnnotation(BussinessLog.class);
        String bussinessName = annotation.value();
        LOGGER.info("{}-{}-{}", bussinessName, className, methodName);
        Object[] params = point.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object param : params) {
            sb.append(param);
            sb.append(PARAM_SEPARTOR);
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - PARAM_SEPARTOR.length());
        }
        // 记录请求的内容
        HttpServletRequest request = RequestHolder.getRequest();
        LOGGER.info("IP: {}, Method: {}, Request URL: {}", IpUtil.getRealIp(request), request.getMethod(), request.getRequestURL().toString());
        LOGGER.info("User-Agent: " + request.getHeader("User-Agent"));
        LOGGER.info("请求参数:{}", sb.toString());
    }
}
