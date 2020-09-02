package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.revature.util.PLog;

@Aspect
@Component
public class LoggingAspect {
	
	@AfterReturning(value = "logMethod()", argNames = "joinPoint")
	public void logInfoAfter(JoinPoint joinPoint) {
		PLog.logger.info(joinPoint.getSignature().getName() + " executed successfully");
	}
	
	@AfterThrowing(pointcut = "execution(* com.revature.controllers.*.*(..))", throwing = "error")
	public void logInfoAfterThrowing(JoinPoint joinPoint, Throwable error) {
		PLog.logger.error(joinPoint.getSignature().getName() + " failed to execute\nError:" + error);
	}
	
	@Pointcut("execution(* com.revature.controllers.*.*(..))")
	public void logMethod() {

	}
}
