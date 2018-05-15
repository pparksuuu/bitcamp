// 파일 업로드 - 다른 클라이언트가 올린 파일을 덮어쓰지 않게 하기
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

@WebServlet("/step05/exam04")
public class Exam04 extends HttpServlet {
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

        // 4) 멀티파트로 전송된 요청 데이터 분석하기
        try {
            Map<String,List<FileItem>> paramMap = upload.parseParameterMap(request);

            out.printf("name=%s\n", paramMap.get("name").get(0).getString("UTF-8"));
            out.printf("age=%s\n", paramMap.get("age").get(0).getString());

            FileItem photo = paramMap.get("photo").get(0);
            String filename = newFilename(photo.getName());
            out.printf("photo=%s\n", filename);

            ServletContext appEnvInfo = request.getServletContext();
            String savedPath = appEnvInfo.getRealPath("/");
            out.println(savedPath);
            photo.write(new File(savedPath + "/" + filename));

        } catch (Exception e) {
            out.println("멀티파트 데이터 분석 중 오류 발생!");
        }
    }

    int count = 0;
    private String newFilename(String originFilename) {
        // 파일 확장자 추출하기
        // 예) test.ok.png
        int lastIndex = originFilename.lastIndexOf(".");
        String extName = "";
        if (lastIndex >= 0) {
            extName = originFilename.substring(lastIndex);
        }
        // 파일명: [현재업로드한시각의 밀리초]-[카운트].[확장자]
        return String.format("%d-%d%s", 
                System.currentTimeMillis(),
                ++count, 
                extName);
    }
}

