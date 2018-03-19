//인스턴스 메서드와 클래스 메서드
package step08;

public class Exam02_1 {
    static class A {
        
        static void m1() {
            System.out.println("m1()");
        }
        
        void m2() {
            System.out.println("m2()");
        }
    }
    public static void main(String[] args) {
        //클래스 메서드 호출
        //문법) 클래스명.메서드명();
        A.m1(); //OK!
        
        // => 인스턴스 메서드는 클래스 이름으로 호출할 수 없다.
        //A.m2(); //컴파일 오류!
        
        A obj1 = new A();
        obj1.m1(); // OK!! 그런데, 이렇게 하지 말라!
             
        obj1.m2(); // OK!! 인스턴스 메서드를 
        
        A obj2 = null;
        obj2.m2(); //컴파일은 OK! 실행은 오류

    }
}

//
