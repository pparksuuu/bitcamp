//인스턴스 메서드 활용  - String 클래스
package step09;

public class Exam02_1 {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        
        //s1 인스턴스(s1 레퍼런스가 가리키는 인스턴스)의 값을 조회하는 메서드 사용
        //따라서 이 메서드를 호출하려면 반드시 String 인스턴스의 주소를 줘야 한다.
        char c = s1.charAt(1);
        System.out.println(c);
        
        System.out.println(s1.compareTo("Helli"));
        System.out.println(s1.compareTo("Hello"));
        System.out.println(s1.compareTo("Hellu"));
        
        System.out.println(s1.contains("ll"));
        System.out.println(s1.contains("ee"));
        
        //두 문자열을 연결하여 새 문자열을 만든다.
        String s2 = s1.concat(" , world!");
        System.out.println(s1);
        System.out.println(s2);
        
        
    }
}
