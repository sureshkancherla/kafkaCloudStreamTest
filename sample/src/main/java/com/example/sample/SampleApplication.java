package com.example.sample;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

	@SpringBootApplication
	@EnableBinding({CallStreams.class})
	public class SampleApplication  extends SpringBootServletInitializer implements WebMvcConfigurer{

		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return configureApplication(builder);
		}

		private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
			return builder.sources(SampleApplication.class).bannerMode(Banner.Mode.OFF);
		}
		
	public static void main(String[] args) {
		
		SpringApplication.run(SampleApplication.class, args);
		
	}
	
	 
}
