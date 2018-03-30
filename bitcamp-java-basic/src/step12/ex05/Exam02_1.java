// java.util.Queue 구현과 사용
package step12.ex05;

import java.util.HashSet;
import java.util.Iterator;

//HashSet 사용처
// => Set은 집합을 의미한다.
public class Exam02_1 {
    public static void main(String[] args) {
        String v1 = new String("aaa");
        String v2 = new String("bbb");
        String v3 = new String("ccc");
        String v4 = new String("ddd");
        String v5 = new String("ccc");
        
        HashSet set = new HashSet();
        set.add(v1);
        set.add(v2);
        set.add(v3);
        set.add(v4);
        set.add(v5); 
        
        //set.get(0); <==이런 메서드가 없다.
        Object[] values = set.toArray();
        for (Object value : values) {
            System.out.print(value + ", ");
        }
        System.out.println();
        
        
        Iterator 컬렉션에서값을꺼내주는객체 = set.iterator();
        
        while (컬렉션에서값을꺼내주는객체.hasNext()) {
            System.out.print(컬렉션에서값을꺼내주는객체.next() + ", ");
        }
        System.out.println();
        
        print(set);
        
    }
    static void print(HashSet set) {
        Object[] values = set.toArray();
        for (Object value : values) {
            System.out.print(value + ", ");
        }
        System.out.println();
    }
}
