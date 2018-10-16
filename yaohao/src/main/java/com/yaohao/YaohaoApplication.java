package com.yaohao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.yaohao.dao")
@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class YaohaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YaohaoApplication.class, args);
	}
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(10);// 单位为S
				container.setPort(8077);
			}
		};
	}
}
