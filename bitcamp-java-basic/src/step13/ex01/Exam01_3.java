// 제네릭(Generic) - 문법 정리
package step13.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam01_3 {
    public static void main(String[] args) {
        
        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member("홍길동", 20));
        
        
        ArrayList<Member> list2 = new ArrayList</*Member*/>();//OK!
        
        ArrayList<Member> list3;
        list3 = new ArrayList<>(); //OK!
    }
}
