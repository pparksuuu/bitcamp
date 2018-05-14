// GET 요청과 POST 요청의 HTTP 프로토콜 비교
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step04/exam01")
public class Exam01 extends GenericServlet {
    
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step04/exam01_test.html
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        
        
        // 클라이언트가 보낸 값을 꺼낼 때는 GET,POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        // UTF-16 ==> UTF-8
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
        
    }
}

// HTTP 프로토콜 - GET 요청
// - request-URI에 데이터를 포함해서 보낸다.
//      URL?파라미터명=값&파라미터명=값ㅋ&파라미터명=값....
//   예) /bitcamp-web01/step04/exam01?name=aaa&age=20 
//GET /bitcamp-web01/step04/exam01?name=aaa&age=20 HTTP/1.1 <== request-line
//Host: localhost:8888   <=== header(general/request/entity)
//Connection: keep-alive
//Pragma: no-cache
//Cache-Control: no-cache
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//Referer: http://localhost:8888/bitcamp-web01/step04/exam01_test.html
//Accept-Encoding: gzip, deflate, br
//Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7



// HTTP 프로토콜 - POST 요청
// - message-body(entity-body)에 데이터를 포함해서 보낸다.
// - post 요청을 할 떄는 보내는 데이터의 정보를 추가한다
// 즉 Content-Length와 Content-Type을 추가해서 보낸다.


//POST /bitcamp-web01/step04/exam01 HTTP/1.1 <== request-line
//Host: localhost:8888 <=== header(general/request/entity)
//Connection: keep-alive
//Content-Length: 15    <=== post 요청할 때만 보내는 헤더 값. 빈 줄 다음에 읽어야 할 바이트의 수
//Pragma: no-cache
//Cache-Control: no-cache
//Origin: http://localhost:8888
//Upgrade-Insecure-Requests: 1
//Content-Type: application/x-www-form-urlencoded    <=== post 요청할 때만 보내는 헤더 값
//User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//Referer: http://localhost:8888/bitcamp-web01/step04/exam01_test.html
//Accept-Encoding: gzip, deflate, br
//Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
//(빈줄) <== empty line
//name=bbb&age=30 <== post 요청은 빈 줄 다음에 데이터를 보낸다.

// GET vs POST
// [GET]
//    - URL에 데이터가 포함되기 때문에 바이너리 데이터를 보낼 수 없다.
//      바이너리 데이터를 BASE64 형식(텍스트형식)으로 변환하여 보낼 수는 있다.
//    - 대용량의 데이터를 보낼 수 없다
//      request-line 및 header의 최대 크기를 8182(8KB)로 제한하고 있따.
//    - 보내는 데이터가 타인에게 노출된다.
//      URL에 데이터가 포함되기 떄문이다.
// [POST]
//    - 멀티파트 형식으로 바이너리 데이터를 보낼 수 있다.
//    - 대용량의 데이터를 보낼 수 있다.
//      빈 줄 다음에 데이터를 보내기 때문에 데이터의 크기에 제한이 업삳.
///     서버 쪽에서 허용하는 만큼 보낼 수 있다.


// BASE 64
// - 바이너리 데이터를 텍스트로 변환하여 전송할 때 사용한다.
// - 바이너리 데이터를 ASCII 코드의 문자로 변환하는 방식이다.
// - 이렇게 텍스트로 만든 데이터를 OS에 상관없이, 프로그래밍 언어에 상관없이,
//   네트워크 프로토콜에 상관없이 언제든 주고 받을 수 있다는 장점이 있다.
