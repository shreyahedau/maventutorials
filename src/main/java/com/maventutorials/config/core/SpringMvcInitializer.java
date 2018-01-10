package com.maventutorials.config.core;

import com.maventutorials.config.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Author: Shreya Hedau : shreya.hedau
 * Date: 28-Nov-17
 */

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
