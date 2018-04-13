
package step22.ex09;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import step22.ex07.Member;

public class Exam03_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/test9_3.data");
        BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);
        ObjectOutputStream out = new ObjectOutputStream(bufOut);

        Member2 member = new Member2();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;

            out.writeObject(member);

        out.close();

        System.out.println("데이터 출력 완료!");
    }
}
// 용어 정리!
// Serialize   : 객체 ===> 바이트 배열   (marshalling 이라고도 부른다.)
// Deserialize : 바이트 배열 ===> 객체   (unmarshalling이라고도 부른다.)




