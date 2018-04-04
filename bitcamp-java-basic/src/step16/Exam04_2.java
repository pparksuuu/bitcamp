// 파일 삭제
package step16;

import java.io.File;

public class Exam04_2 {
    public static void main(String[] args) throws Exception {
        //삭제할 파일의 경로 설정
        File file = new File("temp2/a/test.txt");
        if(file.delete()) {
            System.out.println("test.txt 파일을 삭제하였습니다.");
        } else {
            System.out.println("test.txt 파일을 삭제할 수 없습니다.");
        }
    }
}
