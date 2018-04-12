// 플러그인으로 전환한  - 데이터 읽는데 걸린 시간 측정
package step22.ex07;

import java.io.FileInputStream;

public class Exam02_1 {

    public static void main(String[] args) throws Exception {
        
        FileInputStream fileIn = new FileInputStream("temp/jls8.pdf");
        BufferedInputStream in = new BufferedInputStream(fileIn);

        int b;
        
        long startTime = System.currentTimeMillis(); // 밀리초
        
        int callCount = 0;
        while ((b = in.read()) != -1) callCount++; // 파일을 끝까지 읽는다.
        
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
        System.out.println(callCount);
        
        in.close();
    }

}
