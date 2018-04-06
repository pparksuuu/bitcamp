// IoC 컨테이너 만들기 - 3) .class 파일만 추출하기. 중첩 클래스 제외.
package step19.ex03;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// => FileFilter를 사용하여 .class파일만 추출한다.
public class Exam06 {
    public static void main(String[] args) throws Exception {
        // 1) 패키지 경로를 따로 준비하지 않는다.
        //File packageDir = new File("C:\\Users\\Bit\\git\\bitcamp\\bitcamp-java-basic\\src\\step19\\ex01");
        
        
        // 2) 해당 패키지의 디렉토리에서 파일 목록을 가져오기
        ApplicationContext4 appContext = new ApplicationContext4("step19.ex01");
        List<File> files = appContext.getFiles();
        for (File f : files) {
                System.out.printf("d %s\n", f.getCanonicalPath());
        }
        
    }
}
