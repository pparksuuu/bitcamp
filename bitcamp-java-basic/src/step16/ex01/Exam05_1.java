// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기
package step16.ex01;

import java.io.File;

public class Exam05_1 {

    public static void main(String[] args) {
        File dir = new File(".");
        
        // => 파일이나 디렉토리 이름을 알아내기
        String[] names = dir.list();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
