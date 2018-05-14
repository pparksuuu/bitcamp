// GET 요청과 POST 요청 구분하기  - HttpServlet 클래스의 doXxx() 사용하기
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HTTP 요청을 다루기 위해 매번 ServletRequest와 ServletResponse를
// 형변환해야 한다면 프로그래밍하기가 매우 번거롭다.
// 미리 형변환 처리를 한 클래스가 있으니 그 클래스를 사용하자 
@WebServlet("/step04/exam04")
public class Exam04 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step04/exam04_test.html
    
    // 서블릿 컨테이너가 service(ServletRequest, ServletResponse)를 호출하면
    // 다음 절차를 거치면서 메서드가 호출된다.
    // service(ServletRequest, ServletResponse)
    // => service(HttpSErvletRequest, HttpServletResponse)
    //      => doGet(HttpSErvletRequest, HttpServletResponse)
    //      => doPost(HttpSErvletRequest, HttpServletResponse)
    //      => doHead(HttpSErvletRequest, HttpServletResponse)
    //         ...
    // 따라서, GET 요청을 처리하고 싶다면 service()를 재정의하는 대신에 doGet()을 재정의하면 된다.
    // POST 요청을 처리하고 싶다면 마찬가지로 service()대신에 doPost()를 재정의하면 된다.
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 클라이언트가 GET 요청을 하면 이 메서드가 최종적으로 호출된다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("doGet() 호출됨.");
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 클라이언트가 POST 요청을 하면 이 메서드가 최종적으로 호출된다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("doPost()호출됨!");
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
        
    }
}

