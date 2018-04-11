// 데이터 읽기 - String 값 읽기
package step22.ex03;

import java.io.FileInputStream;

public class Exam04_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        byte[] buf = new byte[100];
        
        int count = in.read(buf);
        
        // 바이트 배열에 들어있는 값을 사용하여 String 인스턴스를 만든다.
        // new String(바이트배열, 시작번호, 개수, 문자코드표)
        
        String str = new String(buf, 0, count);
        
        in.close();
        
        System.out.printf("%s\n", str);
    }
}
