// Byte Stream - 바이트 배열 읽기
package step22.ex02;

import java.io.FileReader;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader("temp/test2.txt");
        
        char[] buf = new char[100];
        
        // read(버퍼의주소) 
        // => 버퍼가 꽉 찰 때까지 읽는다.
        // => 물론 버퍼 크기보다 파일의 데이터가 적으면 파일을 모두 읽어 버퍼에 저장한다.
        // => 리턴 값은 읽은 바이트의 개수이다.
        // => 파일을 읽을 때 JVM의 문자코드표에 따라 바이트를 읽는다.
        //    그리고 2바이트 UTF-16 코드 값으로 변환하여 리턴한다.
        // => JVM의 문자 코드표가 UTF-8이라면,
        //    파일을 읽을 때, 영어나 숫자, 특수기호는 1바이트로 읽어 UTF-16으로 변환할 것이고,
        //    한글은 3바이트를 읽어 UTF-16으로 변환할 것이다.
        int count = in.read(buf); 
        
        in.close();
        
        System.out.printf("%d\n", count);
        for (int i = 0; i < count ; i++)
            System.out.printf("%c(%x) ", buf[i], (int)(buf[i]));
        System.out.println();
    }
}
