// 요청 핸들러의 파라미터 - custom property editor 등록하기
package bitcamp.mvc.web;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_5")
public class Exam05_5 {
    
    // 프론트 컨트롤러는 페이지 컨트롤러를 호출할 때 
    // 기본적으로 클라이언트가 보낸 문자열 데이터를 primitive type의 값으로 변환시켜 준다.
    // 그 외의 타입에 대해서는 개발자가 프로퍼티 값 변환기(property editor)를 등록해야 한다.
    // 테스트:
    // http://localhost:8888/bitcamp-spring-webmvc/mvc/exam05_4/m1?title=aaa&content=bbb&createdDate=2018-06-04
    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1(String title, String content, Date createdDate) {
        return String.format("m1(): %s, %s, %s", title, content, createdDate);
    }
    /*
    @InitBinder // 이렇게 표시를 해야만 프론트 컨트롤러가 요청 핸들러를 호출하기 전에 먼저 이 메서드를 호출한다.
    public void initBinder(WebDataBinder binder) {
        
        // 이 메서드는 요청이 들어올 때 마다 파라미터 값을 준비하기 위해 
        // 파라미터 개수 만큼 호출된다.
        System.out.println("Exam05_4().initBinder()");
        
        // java.lang.String ===> java.sql.Date 변환시켜주는 프로퍼티 에디터 등록
        binder.registerCustomEditor(
                java.sql.Date.class, // 요청 핸들러의 파라미터 타입
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text)
                            throws IllegalArgumentException {
                        // "text" 파라미터는 클라이언트가 보낸 데이터이다.
                        // 이렇게 문자열로 보낸 데이터를 java.sql.Date 객체로 바꿔야 한다.
                       this.setValue(Date.valueOf(text));
                    }
                });
    }
    */
}
