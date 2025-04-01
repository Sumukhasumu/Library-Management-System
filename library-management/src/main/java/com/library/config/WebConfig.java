package com.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * This is the configuration class for setting up the view resolver in a Spring
 * MVC application. It is responsible for configuring how the views (JSPs) are
 * resolved and displayed.
 */
@Configuration
public class WebConfig {

	/**
	 * Bean definition for the view resolver. This method sets up the
	 * InternalResourceViewResolver, which is responsible for resolving JSP views by
	 * adding a prefix and suffix to the view name.
	 * 
	 * @return InternalResourceViewResolver object that resolves JSP views.
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		// Create a new instance of InternalResourceViewResolver
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		// Set the prefix for the view names (where the JSP files are located)
		resolver.setPrefix("/WEB-INF/jsp/");

		// Set the suffix for the view names (extension of JSP files)
		resolver.setSuffix(".jsp");

		// Return the configured view resolver
		return resolver;
	}
}
