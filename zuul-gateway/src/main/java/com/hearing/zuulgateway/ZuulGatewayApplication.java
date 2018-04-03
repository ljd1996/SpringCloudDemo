package com.hearing.zuulgateway;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@EnableConfigurationProperties({FilterConfiguration.class})
public class ZuulGatewayApplication {

//	@Bean
//	public AccessZuulFilter accessZuulFilter() {
//		return new AccessZuulFilter();
//	}

	@Bean
	public FilterLoader filterLoader(FilterConfiguration filterConfiguration) {
		FilterLoader filterLoader = FilterLoader.getInstance();
		filterLoader.setCompiler(new GroovyCompiler());
		System.out.println(filterConfiguration.getRoot() + "-" + filterConfiguration.getInterval());
		try {
			FilterFileManager.setFilenameFilter(new GroovyFileFilter());
			FilterFileManager.init(
					filterConfiguration.getInterval(),
					filterConfiguration.getRoot() + "/pre",
					filterConfiguration.getRoot() + "/post"
			);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return filterLoader;
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
}
