package com.soni.web.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.soni.config.RootConfig;
import com.soni.config.WebConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		 return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		 return new String[]{"/"};
	}
	
//	@Override
//    public void onStartup(ServletContext container) {
//      // 创建Spring的root配置环境
//      AnnotationConfigWebApplicationContext rootContext =
//        new AnnotationConfigWebApplicationContext();
//      rootContext.register(RootConfig.class);

//      // 将Spring的配置添加为listener
//      container.addListener(new ContextLoaderListener(rootContext));
//
//      // 创建SpringMVC的分发器
//      AnnotationConfigWebApplicationContext dispatcherContext =
//        new AnnotationConfigWebApplicationContext();
//      dispatcherContext.register(DispatcherConfig.class);
//
//      // 注册请求分发器
//      ServletRegistration.Dynamic dispatcher =
//        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
//      dispatcher.setLoadOnStartup(1);
//      dispatcher.addMapping("/");
 //   }

}
