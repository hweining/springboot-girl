package com.imooc.girl;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public aspect HttpAspect {
	@Before("execution(public * com.imooc.girl.controller.GirlController.girlList(..))")
	public void log(){
		System.out.println("被拦截了");

	}

	@After("execution(public * com.imooc.girl.controller.GirlController.girlList(..))")
	public void doAfter(){
		System.out.println("我是方法执行之后被拦截");
	}

}
