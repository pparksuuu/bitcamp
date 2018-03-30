// 제네릭(Generic) - 문법 정리
package step13.ex01;

import java.util.HashMap;

public class Exam01_3 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("aaa", "문자열");
        map.put(new Integer(100), new Member("홍길동", 20));
        
        // 명확하게 Object 타입을 지정하는 것이 좋다.
        HashMap<Object, Object> map2 = new HashMap<>();
        map2.put("aaa", "문자열");
        map2.put(new Integer(100), new Member("홍길동", 20));

        
        // key : String
        // value : Member
        HashMap<String, Member> map3 = new HashMap<>();
        //map3.put("aaa", "문자열"); //컴파일 오류!
        //map3.put(new Integer(100), new Member("홍길동", 20));// 컴파일 오류
        map3.put("aaa", new Member("홍길동", 20)); //OK!
        
        Member m = map3.get("aaa");
        
        

        
        
    }
}
