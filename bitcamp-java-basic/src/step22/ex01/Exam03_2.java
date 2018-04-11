// 읽은 데이터를 바이트 배열의 특정 위치에 저장하기.
package step22.ex01;

import java.io.FileInputStream;

public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test1.data");
        
        // 바이트들을 저장할 배열을 준비한다.
        byte[] buf = new byte[100];
        
        //read(버퍼의주소, 저장할위치, 읽을 바이트 개수)
        // 리턴 값은 실제 읽은 바이트의 개수이다.
        int count = in.read(buf, 10, 40); 
        
        // 3) 읽기 도구를 닫는다.
        // => 항상 입출력 도구를 사용한 후 닫아야 한다.
        // => 어떤 입출력 도구는 닫지 않으면 버퍼(입출력메모리)에 남아있는 데이터가
        //    출력되지 않고 버려진다.
        in.close();
        System.out.printf("%d\n", count);
        for (int i = 10; i < count + 10; i++)
            System.out.printf("%x ",buf[i]);
        System.out.println();
    }
}
