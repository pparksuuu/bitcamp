// ObjectOutputStream
package step22.ex09;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import step22.ex07.Member;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/test9_3.data");
        BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);
        ObjectOutputStream out = new ObjectOutputStream(bufOut);

        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;

        // ObjectOutputStream은 인스턴스의 값을 바이트 배열로 만들어 출력하는 기능이 있다.
            out.writeObject(member);
            // 실행하면 오류가 발생

        out.close();

        System.out.println("데이터 출력 완료!");
    }
}
