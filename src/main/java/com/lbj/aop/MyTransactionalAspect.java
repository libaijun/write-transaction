package com.lbj.aop;

import com.lbj.annotation.MyTransactional;
import com.lbj.template.ConnectionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;

/**
 * @author: lbj
 * @create: 2019-11-23 18:35
 */
@Aspect
@Component
public class MyTransactionalAspect {

    @Resource
    private ConnectionManager connectionManager;

    @Around("@annotation(myTransactional)")
    public void doTransactional(ProceedingJoinPoint proceedingJoinPoint, MyTransactional myTransactional) throws Throwable {
        Connection conn = null;
        try {
            System.out.println("setAutoCommit false");
            conn = connectionManager.getConnection();
            conn.setAutoCommit(false);

            proceedingJoinPoint.proceed();

            conn.commit();
            System.out.println("=====事务提交======");
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            System.out.println("=====事务回滚=====");
        }
    }
}
