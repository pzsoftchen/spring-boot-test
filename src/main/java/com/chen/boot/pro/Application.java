package com.chen.boot.pro;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Application
 *
 * @author Chenpz
 * @package com.chen.boot.pro
 * @date 2018/3/21/15:15
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		
		return builder
				.sources(Application.class)
				.bannerMode(Banner.Mode.OFF);
	}
	
	public static void main (String[] args) {
		SpringApplication.run(Application.class);
		
	}
	
}
