// IoC 컨테이너 만들기 - 6) 클래스 객체를 생성하
package step19.ex05;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// => 클래스 이름으로 해당 클래스를 로딩한 후 Class 객체를 가져온다.
//    왜? Class 객체가 있으면 언제라도 인스턴스를 생성핤 ㅜ 있기 때문이다.
public class Exam08 {
    public static void main(String[] args) throws Exception {
        // 1) 패키지 경로를 따로 준비하지 않는다.
        //File packageDir = new File("C:\\Users\\Bit\\git\\bitcamp\\bitcamp-java-basic\\src\\step19\\ex01");
        
        
        // 2) 해당 패키지의 디렉토리에서 파일 목록을 가져오기
        ApplicationContext6 appContext = new ApplicationContext6("step19.ex01");
        List<Class> classes = appContext.getFiles();
        for (Class clazz : classes) {
                System.out.println(clazz.getName());
        }
        
    }
}
