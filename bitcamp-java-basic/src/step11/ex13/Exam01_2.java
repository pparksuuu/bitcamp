// 캡슐화(encapsulation) - 접근제한
package step11.ex13;

public class Exam01_2 {
    
    public static void main(String[] args) {
        //환자 데이터를 등록해보자.
        Customer2 c1 = new Customer2();
        c1.name = "홍길동";
        c1.age = 300;
        c1.weight = 100;
        c1.height = -50;
     
        // 해결책?
        // => 이 클래스에서 제공하는 메서드를 사용해라 !
        // => Exam01_3.java를 확인 !
    }

}
