package bitcamp.java106.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.support.WebApplicationContextUtils;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    static ApplicationContext container;

    public static ApplicationContext getApplicationContext() {
        return container;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String configClassName = sc.getInitParameter("contextConfigLocation");

        try {
            ApplicationContext iocContainer = 
                    new AnnotationConfigApplicationContext(
                            Class.forName(configClassName));
            
            container = iocContainer;
            
            // 서블릿에서 스프링 IoC 컨테이너를 꺼내 쓸 수 있도록,
            // WebApplicationContextUtils에 보관한다.
            WebApplicationContextUtils.containers.put(
                    sce.getServletContext(), iocContainer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
