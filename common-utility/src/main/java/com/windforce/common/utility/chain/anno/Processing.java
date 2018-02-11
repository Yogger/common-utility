package com.windforce.common.utility.chain.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.windforce.common.utility.chain.Way;

/**
 * 处理节点方法声明注解
 * @author frank
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Processing {

	/**
	 * 处理任务名
	 * @return
	 */
	String name();
	
	/**
	 * 处理序号
	 * @return
	 */
	int index() default 0;
	
	/**
	 * 处理方向
	 * @return
	 */
	Way way() default Way.IN;
}
