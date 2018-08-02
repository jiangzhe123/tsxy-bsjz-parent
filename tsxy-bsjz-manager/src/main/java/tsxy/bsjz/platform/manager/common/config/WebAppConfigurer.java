package tsxy.bsjz.platform.manager.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import tsxy.bsjz.platform.manager.common.interceptor.LoginInterceptor;


/**
 * 项目web配置
 * 姜哲
 *
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
	
	/**
	 * 添加自定义的静态资源映射
	 * 这样使用代码的方式自定义目录映射，并不影响Spring Boot的默认映射，可以同时使用。
	 */
	public static String LOGIN_USER = "loginUser";
	
    public WebAppConfigurer() {
        super();
    }
    //因为新加了拦截器，这里需要重新设置资源地址
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    /**
     * 解决跨域问题  allowCredentials为true的时候 allowedOrigins为前端服务器地址
     * http://localhost:8080  前后端 分离 开发情况下打开   部署时候关闭
     * http://www.tsxybsjz.club
     * http://www.tsxybsly.club
     * http://118.89.246.66
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("http://118.89.246.66")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600);
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    /**
	 * 配置拦截器
	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截,"/route/selectRouteByManager","/manager/**"
		registry.addInterceptor(new LoginInterceptor());
		super.addInterceptors(registry);
    }
	
}
