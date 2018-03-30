// 제네릭(Generic)
package step12.ex06;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Exam04_1 {
    
    public static void main(String[] args) {
        // HaspMap이 어떤 종류(타입, 클래스)의 데이터를 다룰 것인지 지정하지 않으면
        // 기본이 Object 타입으로 간주한다.
        HashMap map = new HashMap();
        map.put("k01", new Member("홍길동", 20));
        map.put("k02", new Member("임꺽정", 30));
        map.put("k03", new Member("유관순", 16));
//        map.put("s04", v4);
//        map.put("s05", v5);
        
        
        
    }
}
