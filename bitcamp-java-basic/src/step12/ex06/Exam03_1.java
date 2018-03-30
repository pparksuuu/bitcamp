// HashMap - 값을 저장할 때 key를 사용하여 저장한다.
package step12.ex06;

import java.util.HashMap;
import java.util.Hashtable;

// HashMap vs Hashtable
public class Exam03_1 {
    
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(null, "홍길동"); // null을 key로 사용할 수 있다.
        map.put("s01", null); //value가 null이 될 수 있다.
                              //동기화를 지원하지 않는다. 멀티 스레드가 동시에 사용할 때 문제가 발생할 수 있다.
        Hashtable table = new Hashtable();
        //table.put(null, "홍길동"); //실행 오류! key가 null이 될 수 없다.
        //table.put("s01", null); //실행 오류 !table은 value가 null이 될 수 없다.
        
    }
}
