package com.windforce.common.utility.chain.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 处理方法的参数注入声明
 * @author frank
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface InNotice {

	/**
	 * 注入的参数类型
	 * @return
	 */
	Type type() default Type.CONTENT;
}
