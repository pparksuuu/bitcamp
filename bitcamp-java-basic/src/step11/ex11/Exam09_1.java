// 오버라이딩(overriding) - 응용 예 
package step11.ex11;

public class Exam09_1 {
    
    public static void main(String[] args) {
        // Object 클래스?
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        
        System.out.println(s1 == s2); //주소가 같으니까 false
        System.out.println(s1.equals(s2)); // 내용물이 같으니까 true
        // String 클래스에서 equals()를 오버라이딩 했기 때문에 
        // s1.equals(s2)의 결과가 true가 나온 것이다.
        
    }
}


