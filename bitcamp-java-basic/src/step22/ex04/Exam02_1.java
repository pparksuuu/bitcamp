// 객체 출력 - instance 값 출력
package step22.ex04;

import java.io.FileOutputStream;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        DataOutputStream out = new DataOutputStream("temp/test4_2.data");
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;

        // 인스턴스의 값을 출력하라!
        // 1) 이름 출력
        out.writeUTF(member.name); 
        
        // 2) 나이 출력 (4바이트)
        out.writeInt(member.age);
        
        // 3) 성별 출력 (1바이트)
        out.writeBoolean(member.gender);
        
        out.close();
        
        System.out.println("데이터 출력 완료!");
    }
}
