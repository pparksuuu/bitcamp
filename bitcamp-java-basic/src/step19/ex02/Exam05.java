// IoC 컨테이너 만들기 - 1) 특정 패키지의 파일 목록 알아내기
package step19.ex02;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// => 디렉토리의 파일 목록을 다루는 메서드를 별도의 클래스로 분리한다.
public class Exam05 {
    public static void main(String[] args) throws Exception {
        // 1) 패키지 경로를 따로 준비하지 않는다.
        //File packageDir = new File("C:\\Users\\Bit\\git\\bitcamp\\bitcamp-java-basic\\src\\step19\\ex01");
        
        
        // 2) 해당 패키지의 디렉토리에서 파일 목록을 가져오기
        ApplicationContext3 appContext = new ApplicationContext3("step19.ex01");
        List<File> files = appContext.getFiles();
        for (File f : files) {
                System.out.printf("d %s\n", f.getCanonicalPath());
        }
        
    }
}
