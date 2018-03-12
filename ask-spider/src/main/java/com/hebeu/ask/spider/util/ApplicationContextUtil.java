package com.hebeu.ask.spider.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * spring bean工具类
 * <p>
 *
 * @author chendehua
 * @date 18/03/12
 */
@Service
public class ApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext appCtx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appCtx = applicationContext;
	}

	public static ApplicationContext getCtx() {
		return appCtx;
	}

	public static Object getBean(String beanName) {
		return appCtx.getBean(beanName);
	}

	public static <T> T getBean(Class<T> type) {
		return appCtx.getBean(type);
	}

}
