//흐름 제어문 - for 반복문과 컬렉션
package step05;

import java.util.ArrayList;

public class Exam04_4 {
    public static void main(String[] args) {

        //배열 -> 같은 타입만 , 크기 고정적
        //컬렉션 -> 다른 타입도 , 크기 가변적
        ArrayList list = new ArrayList();
        list.add("홍길동");
        list.add(3.14f);
        list.add(true);
        list.add(365);


        //특정 범위, index를 알아야할 때 !!!

        for(int i = 0; i < list.size(); i++) 
            System.out.println(list.get(i));
        
        System.out.println("===========================");

        //처음부터 다 꺼내려 할 때 !!!

        //컬렉션도 for 문을 적용할 수 있다.
        // for(변수선언 : 컬렉션객체) 문장;
        for(Object value : list)
            System.out.println(value);        
    }
}