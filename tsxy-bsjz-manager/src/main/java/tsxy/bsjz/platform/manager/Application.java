package tsxy.bsjz.platform.manager;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan("tsxy.bsjz.platform")
@EnableCaching
@EnableScheduling
@ServletComponentScan // 扫描使用注解方式的servlet
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    // 注意这里要指向原先用main方法执行的Application启动类  打包需要 就是修改完后不要运行该项目，会报错的。
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
