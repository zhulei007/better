package com.better.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * 封装Spring ApplicationConext引用, 方便工程通过API获取bean实例
 * @author zhulei
 *
 */
@Component
public class SpringContextWrapper implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextWrapper.appContext = applicationContext;

	}
	private static ApplicationContext appContext;

	/**
	* 根据beanName 获取bean实例
	* @param beanName
	* @return
	*/
	public static Object getBean(String beanName){
		Object obj = null;
		if (null != appContext){
			obj =  appContext.getBean(beanName);
		}
		return obj;
	}
	
	/**
	* 根据bean名称和类型进行获取Bean的实例
	* @param beanName
	* @param clsType
	* @return
	*/
	public static <T> T getBean(String beanName, Class<T> clsType){
		T obj = null;
		if (null != appContext){
			obj =  appContext.getBean(beanName, clsType);
		}
		return obj;
	}
	
	/**
	* 根据类型进行获取Bean的实例
	* @param clsType
	* @return
	*/
	public static <T> T getBean(Class<T> clsType){
		T obj = null;
		if (null != appContext){
			obj =  appContext.getBean(clsType);
		}
		return obj;
	}

}
