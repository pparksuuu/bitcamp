// 프론트 컨트롤러 구현
package bitcamp.java106.pms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

    ApplicationContext iocContainer;

    @Override
    public void init() throws ServletException {

        try {
            // 서블릿 컨테이너가 시작되면 스프링 IoC 컨테이너를 준비한다. 
            iocContainer = 
                    new ClassPathXmlApplicationContext(
                            this.getServletConfig().getInitParameter("contextConfigLocation"));

            // 다른  서블릿에서 스프링 IoC 컨테이너를 꺼내 쓸 수 있도록,
            // WebApplicationContextUtils에 보관한다.
            WebApplicationContextUtils.containers.put(
                    this.getServletContext(), iocContainer);

            String[] beanNames = iocContainer.getBeanDefinitionNames();
            System.out.println("------------------");
            for (String name : beanNames) {
                System.out.println(name);
            }
            System.out.println("------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response)
                    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 클라이언트가 요청한 서블릿의 경로를 알아내기
        String servletPath = request.getServletPath().replace(".do", "");


        // 클라이언트가 요청을 처리할 페이지 컨트롤러를 얻기.
        PageController pageController = (PageController) iocContainer.getBean(servletPath);

        // 페이지 컨트롤러 실행
        try {
            String viewUrl = pageController.service(request, response);
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                request.getRequestDispatcher(viewUrl).include(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류 발생!");
        }
    }
}

// ver 45 - 클래스 추가
