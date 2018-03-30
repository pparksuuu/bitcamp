// 제네릭(Generic) - 사용 후
package step13.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam01_2 {
    public static void main(String[] args) {
        // 1) Generic을 사용하여 ArrayList가 어떤 종류(타입, 클래스)의 객체를
        //    저장할 것인지 지정할 수 있다.
        //    즉 타입 이름을 파라미터로 전달하여 처리할 수 있다.
        
        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member("홍길동", 20));
        
//        list.add(new String("Hello"));
//        list.add(new Integer(100));
//        list.add(new HashSet());
        
        Member member = list.get(0);
        System.out.println(member.name);
        System.out.println(member.age);
        
    }
}
