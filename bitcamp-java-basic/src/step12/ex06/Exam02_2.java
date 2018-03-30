// HashMap - 값을 저장할 때 key를 사용하여 저장한다.
package step12.ex06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Exam02_2 {
    
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
        
        // => HashMap에서 key 목록을 꺼내기.
        //1)
        Set keys = map.keySet(); 
        
        Iterator 키를꺼내주는객체 = keys.iterator();
        while (키를꺼내주는객체.hasNext()) {
            Object key = 키를꺼내주는객체.next();
            System.out.println(map.get(key));
        }
        
        //2)
        System.out.println("===========================");
        Object[] keyArr = keys.toArray();
        for (Object key : keyArr) {
            System.out.println(map.get(key));
        }
        
        System.out.println("===========================");

        //3) 만약 컬랙션 객체가 java.util.Collection 규칙을 따라 만든 클래스라면
        // for(:) 반복문을 바로 사용할 수 있다.
        for (Object key : keys/*배열 또는 Collection 객체*/) {
            System.out.println(map.get(key));
        }
        System.out.println("===========================");

        
    }
}
