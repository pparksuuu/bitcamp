// HashMap - 값을 저장할 때 key를 사용하여 저장한다.
package step12.ex06;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Exam02_1 {
    
    public static void main(String[] args) {
        Member v1 = new Member("홍길동", 20);
        Member v2 = new Member("임꺽정", 30);
        Member v3 = new Member("유관순", 16);
        Member v4 = new Member("안중근", 20);
        Member v5 = new Member("윤봉길", 25);
        
        HashMap map = new HashMap();
        
        map.put("s01", v1);
        map.put("s02", v2);
        map.put("s03", v3);
        map.put("s04", v4);
        map.put("s05", v5);

        Set entrySet = map.entrySet(); //key/value가 한 쌍으로 묶여있는 객체들이 들어있는 집합.
        
        for (Object obj : entrySet) {
            Entry entry = (Entry)obj;
            System.out.printf("%s ===> %s\n", entry.getKey(), entry.getValue());
            
        }
        
        
        
        System.out.println("===========================");

        
    }
}
