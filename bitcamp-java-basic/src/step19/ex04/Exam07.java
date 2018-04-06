// IoC 컨테이너 만들기 - 4) 파일 경로 ㅐㄷ신 패키지 이름을 포함한 클래스 이름을 추출한다.
package step19.ex04;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// => 전체 클래스 이름 출력
public class Exam07 {
    public static void main(String[] args) throws Exception {
        // 1) 패키지 경로를 따로 준비하지 않는다.
        //File packageDir = new File("C:\\Users\\Bit\\git\\bitcamp\\bitcamp-java-basic\\src\\step19\\ex01");
        
        
        // 2) 해당 패키지의 디렉토리에서 파일 목록을 가져오기
        ApplicationContext5 appContext = new ApplicationContext5("step19.ex01");
        List<String> classnames = appContext.getFiles();
        for (String name : classnames) {
                System.out.println(name);
        }
        
    }
}
