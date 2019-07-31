package com.stanley.autocomplete.autocomplete;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stanley.autocomplete.autocomplete.controller.utils.CorsFilter;

@SpringBootApplication
public class AutocompleteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutocompleteApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilterChain() {
		final FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new CorsFilter());
		registrationBean.setName("cors-webservice-rest-filter");
		String[] urls = { "/*" };
		registrationBean.setUrlPatterns(Arrays.asList(urls));
		return registrationBean;
	}

}
