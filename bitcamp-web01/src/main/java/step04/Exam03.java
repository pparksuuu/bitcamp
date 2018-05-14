// GET 요청과 POST 요청 구분하기  - HttpServlet 클래스
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
@WebServlet("/step04/exam03")
public class Exam03 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step04/exam02_test.html
    
    // => service() 메서드를 오버라이딩 할 때 도 Servlet 인터페이스에 선언된
    //    원래의 service(ServletRequest, ServletResponse)를 오버라이딩 하지 말고,
    //    HttpServlet 클래스에서 추가한(오버로딩) service() 메서드를 오버라이딩하라!
    // => 이 메서드는 파라미터 값으로 HttpSErvletRequest와 HttpServletResponse를 받는다.
    //    물론 섯블릿 컨테이너가 이 메서드를 직접 호출하ㄴ면,
    //    service(ServletRe
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        // 클라이언트가 보낸 값을 꺼낼 때는 GET,POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        // 이 메서드를 재정의하면 다음과 같이 파라미터 값을 원래의 타입으로 형변환할 필요가 없드
        // => 즉 오리지널 service(ServletRequest, ServletResponse)를 재정의하는 것보다
        //    이 메서드를 재정의하는 것이 코딩하는데 편하다.
        // HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        // ServletRequest에는 "HTTP method" 를 알아내는 메서드가 없다.
        
        // 원래의 타입인 HttpServletRequest에는 "HTTP method" 를 알아내는 메서드가 있다.
        //String method = httpRequest.getMethod();
        
        String method = request.getMethod();
        
        // UTF-16 ==> UTF-8
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("요청 방식=%s\n", method);
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
        
    }
}

