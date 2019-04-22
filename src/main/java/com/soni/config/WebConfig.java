package com.soni.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.soni.rest")
public class WebConfig implements WebMvcConfigurer  {
 
	//  配置默认的defaultServlet处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 配置静态资源处理
        configurer.enable("default");//对静态资源的请求转发到容器缺省的servlet，而不使用DispatcherServlet
    }

    /**
     * 这是定义一个ParameterizableViewController调用时立即转到视图的快捷方式。
     * 如果在视图生成响应之前没有Java控制器逻辑要执行，则在静态情况下使用它。
     * <mvc:view-controller path="/" view-name="home"/>
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
   /**
     * 静态资源访问控制：假如defaultServlet 没有过滤到接收的静态资源是会报404的
     * 配置addResourceHandlers 不能继承WebMvcConfigurationSupport
     * 因为它拥有子类DelegatingWebMvcConfiguration 已经重写了这个方法。所以运行时，在它方法debug的时候，
     * 发现我写的方法一点用都没 注意！！！
     * 下面相当于
     * <mvc:resources mapping="/resources/**"    location="/statics/" />
     * 支持location="classpath:xxxxx"
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("/statics/");
    }

}
