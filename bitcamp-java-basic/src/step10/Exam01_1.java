// String - "Hello" vs new String("Hello")
package step10;

public class Exam01_1 {
    public static void main(String[] args) {
        
        //Heap 메모리 영역에  String 인스턴스를 생성하는 방법
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        if (s1 == s2)
            System.out.println("s1 == s2");
        else
            System.out.println("s1 != s2");
        
        //string constant pool 메모리 영역에 String 인스턴스 생성
        String x1 = "Hello";
        String x2 = "Hello";
        if (x1 == x2)
            System.out.println("x1 == x2");
        else
            System.out.println("x1 != x2");
    }
}
