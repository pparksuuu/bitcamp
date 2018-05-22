package bitcamp.java106.pms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.AppConfig;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

//서블릿 컨테이너가 시작될 때 스프링 IoC 컨테이너를 준비한다.
// => 기존의 InitServlet 역할을 대체한다.
//
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    static ApplicationContext container;
    
    public static ApplicationContext getApplicationContext() {
        return container;
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        container = iocContainer;
        
        // 서블릿에서 스프링 IoC 컨테이너를 꺼내쓸 수 있도로그
        // WebApplicationContextUtils에 보관.
        WebApplicationContextUtils.containers.put(
                sce.getServletContext(), iocContainer);
        
    }
}
