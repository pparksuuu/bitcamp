//인스턴스 메서드와 클래스 메서드의 활용 - Calendar 클래스
package step09;

import java.util.Date;

public class Exam02_5 {
    public static void main(String[] args) throws Exception {
        Date d1 = new Date();
        
        //인스턴스 메서드 활용
        System.out.println(d1.getYear() + 1900);
        System.out.println(d1.getMonth() + 1);
        System.out.println(d1.getDate());
        
        //스태틱 메서드 활용
        long millis = Date.parse("Sat, 12 Aug 1995 13:30:00 GMT");
        System.out.println(millis);
        
        //java.util.Date 대신 java.sql.Date - 둘 다 클래스 이름이 동일하기 때문에 계속 명시해줘야 한다.
        
        //스태틱 메서드 활용
        long currMillis = System.currentTimeMillis();
        
        //생성자 활용
        java.sql.Date today = new java.sql.Date(currMillis);
        
        //인스턴스 메서드 활용
        String str = today.toString(); //toString -> 인스턴스 메소드
        System.out.println(str);
        
        //스태틱 메서드 활용
        java.sql.Date d = java.sql.Date.valueOf("2018-03-21"); 
        
        
        
    }
}
