// Serialize의 대상 클래스가 변경된 경우
package step22.ex09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exam02_4 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test9_3.data");
        BufferedInputStream bufIn = new BufferedInputStream(fileIn);
        ObjectInputStream in = new ObjectInputStream(bufIn);

        // 실행하기 전 해야할 일
        // 1) test9_3.data 파일을 읽기 전에 
        //    Member2 클래스에 전화 번호를 저장할 수 있는 인스턴스 변수를 추가한다
        Member2 member = (Member2) in.readObject();

        in.close();

        System.out.println(member);
    }
}

// 용어 정리!
// Serialize   : 객체 ===> 바이트 배열   (marshalling 이라고도 부른다.)
// Deserialize : 바이트 배열 ===> 객체   (unmarshalling이라고도 부른다.)




