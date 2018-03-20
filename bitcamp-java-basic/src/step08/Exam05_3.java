//변수의 초기화 - 초기화 문장rhk todtjdwkdml tlfgod tnstj
package step08;

public class Exam05_3 {
    
    static class A {
        int a = 100;
        
        //생성자는 초기화 문장을 실행한 후에 호출된다.
        A() {
            this.a = 300;
        }
    }

    
    public static void main(String[] args) {
        A obj1 = new A();
        System.out.println(obj1.a);
    }
}








