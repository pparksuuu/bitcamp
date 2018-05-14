// 파일 업로드 - 멀티파트파라미터 값 추출하기
package step05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

// 웹브라우저에서 파일을 보낼 때 POST 방식으로 보내기 때문에 
// 서블릿에서는 POST 요청을 처리해야 한다.
// 그래서 HttpServlet을 상속 받아 만들고,
// doPost()를 재정의 한다.

@WebServlet("/step05/exam02")
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 멀티파트로 전송된 POST 요청 데이터를 추출하려면 일반적인 방법으로는 안된다.
        // Apache.org사이트의 라이브러리 추가
        request.setCharacterEncoding("UTF-8");

        // apache-fileupload 라이브러리를 사용하여 클라이언트가 보낸 멀티파트 데이터를 추출해보자
        // 1) 클라이언트가 보낸 데이터가 멀티파트 형식인지 검사한다.
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            out.println("멀티파트 형식이 아닙니다!");
            return;
        }

        // 2) 멀티파트 데이터를 추출하여 HDD에 저장할 공장  준비
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 3) 멀티파트 데이터 분석기에 공장 객체를 장착한다.
        // => 멀티파트 데이터 분석기가 멀티파트 데이터를 추출하면 
        //    공장 객체가 파일로 만들어 HDD에 저장한다.
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 4) 멀티파트 데이터 분석하기
        Map<String,String> paramMap = new HashMap<>();
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) { // 일반적인 텍스트 항목일 경우
                    // 파라미터의 한글이 깨질 경우,
                    // => request.setCharacterEncoding("UTF-8")은 소용 없다.
                    //    이 코드는 멀티파트가 아닌 application/x-www-form-urlencoded로 전송된
                    //    데이터에 대해서만 동작한다.
                    // => 해결책? grtString(문자표)를 호출하라!
                    out.printf("%s=%s\n", 
                            item.getFieldName(), // 파라미터 명 
                            item.getString("UTF-8")); // 파라미터 값
                    
                } else { // 파일일 경우, 
                    out.printf("%s=%s\n", 
                            item.getFieldName(), // 파라미터 명
                            item.getName()); //파일명
                    // 클라이언트가 보낸 파일을 저장하자!
                    // - 임의의 폴더에 저장하면 웹 브라우저에서 업로드한 파일을 다시 다운로드 받기 어렵다.
                    //   임의의 폴더? 웹브라우저에서 접근할 수 없는 폴더를 말한다.
                    // - 임의의 폴더에 저장한 경우, 다운로드를 처리해주는 서블릿을 별도로 만들어야 한다.
                    // 좀 더 쉬운 방법은?
                    // - 웹브라우저가 접근할 수 있는 폴더에 저장하자!
                    // - 단 이 방법은 웹브라우저에서 너무 쉽게 특정 파일을 접근할 수 있기 때문에
                    //   보안에 취약하다.
                    // 실무는 어떤 방식을 취하나?
                    // - 웹브라우저가 접근할 수 없는 곳에 저장한다.
                    // - 오직 다운로드 서블릿을 동해서만 허가된 사용자가 다운로드 받을 수 있도록 한다.
                    //
                    // 여기서는 파일업로드 다운로드를 테스트하는데 집중하기 위해서
                    // 임의의 폴더가 아닌 웹 브라우저에서 접근할 수 있는 폴더에 저장하겠다.
                    // 즉 배치 폴더에 저장하겠다
                    // 배치 폴더에 저장하기 위해서는 배치 폴더의 전체 경로를 알아야 한다.
                    // => 웹 애플리케이션 환경 정보를 다루는 객체를 얻는다.
                    ServletContext appEnvInfo = request.getServletContext();
                    // => ServletContext 객체를 통해 웹 애플리케이션의 루트 디렉토리의
                    //    실제 경로를 알아낸다.
                    String savedPath = appEnvInfo.getRealPath("/");
                    out.println(savedPath);
                    
                    // => FileItem.write(저장할 경로) 호출하여 클라이언트가 보낸 파일을 저장한다.
                    item.write(new File(savedPath +"/" + item.getName()));
                }
            }
        } catch (Exception e) {
            out.println("멀티파트 데이터 분석 중 오류 발생!");
        }

    }
}

