// ObjectInputStream으로 Serialize 데이터를 읽기
package step22.ex09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import step07.Score3;

public class Exam04_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test9_5.data");
        BufferedInputStream bufIn = new BufferedInputStream(fileIn);
        ObjectInputStream in = new ObjectInputStream(bufIn);

        Score s = (Score) in.readObject();
        // 주의!
        // => deserialize를 통해 인스턴스가 생성될 때는 생성자가 호출되지 않는다
        in.close();

        // => transient 변수의 값은 출력되지 않았기 때문에 읽을 수 없다.
        System.out.println(s);
        
        // => transient 값은 인스턴스를 준비한 후 별도의 메서드를 통해 다시 계산해야 한다.
        s.compute();
        System.out.println(s);
        
    }
}

// 용어 정리!
// Serialize   : 객체 ===> 바이트 배열   (marshalling 이라고도 부른다.)
// Deserialize : 바이트 배열 ===> 객체   (unmarshalling이라고도 부른다.)




