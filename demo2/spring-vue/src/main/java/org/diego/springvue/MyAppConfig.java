package org.diego.springvue;

import org.diego.springvue.webhelper.CheckLoginHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 读取各种配置
 * 
 * @author cys
 *
 */
@Component
@EnableWebMvc
@Configuration
public class MyAppConfig implements WebMvcConfigurer, WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	@Value("${myapp.port}")
	int appPort;

	@Value("${vue.domain}")
	String vueDomain;

	public int getAppPort() {
		return appPort;
	}

	public void setAppPort(int appPort) {
		this.appPort = appPort;
	}

	public String getVueDomain() {
		return vueDomain;
	}

	public void setVueDomain(String vueDomain) {
		this.vueDomain = vueDomain;
	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		factory.setPort(this.appPort);
	}

	// 覆盖, 增加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);

		// addPathPatterns 添加拦截规则
		// excludePathPatterns 添加排除规则
		registry.addInterceptor(new CheckLoginHandler()).addPathPatterns("/**");
	}


}
