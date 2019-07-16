package com.personal.business.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @author zhangqingqing
 * @version WebMvcConfig, v0.1 2018/6/6 10:56
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    @Autowired
//    private TokenInterceptor tokenInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:"+ File.separator+"META-INF"+ File.separator+"resources"+ File.separator);

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:"+ File.separator+"META-INF"+ File.separator+"resources"+ File.separator+"webjars"+ File.separator);

        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:"+ File.separator+"templates"+ File.separator);
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/api/**")
//                .excludePathPatterns(excludePathPatterns);
        
	}
    
    
}