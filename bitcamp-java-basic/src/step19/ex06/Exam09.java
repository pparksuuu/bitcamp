// IoC 컨테이너 만들기 - 5) 클래스 이름으로 Class 객체를 만든다.
package step19.ex06;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import step19.ex05.ApplicationContext6;

// => 클래스 이름으로 해당 클래스를 로딩한 후 Class 객체를 가져온다.
//    왜? Class 객체가 있으면 언제라도 인스턴스를 생성핤 ㅜ 있기 때문이다.
public class Exam09 {
    public static void main(String[] args) throws Exception {
        // 1) 패키지 경로를 따로 준비하지 않는다.
        //File packageDir = new File("C:\\Users\\Bit\\git\\bitcamp\\bitcamp-java-basic\\src\\step19\\ex01");
        
        
        // 2) 해당 패키지의 디렉토리에서 파일 목록을 가져오기
        ApplicationContext7 appContext = new ApplicationContext7("step19.ex01");
        List<Object> objects = appContext.getObjects();
        for (Object obj : objects) {
                System.out.println(obj.getClass().getName());
        }
        
        
    }
}
