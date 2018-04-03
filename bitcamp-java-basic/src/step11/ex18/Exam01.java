// 상속 - Generalization 수행 후
package step11.ex18;

// Car 클래스의 start() shutdown()은 서브 클래스에서 그대로 받아 사용해도 된다.
// 그러나 run() 매서
public class Exam01 {
    public static void main(String[] args) {
        Car c = new Car();
        
        // => 이런 경우를 방지하기 위해. 
        //    즉 Car 클래스의 경우처럼 서브클래스에 공통 기능을 상속해주는 용도로 만든 클래스를
        //    직접 사용하지 못하도록 막기위해 만든 문법이
        //    "추상클래스(abstract)"이다.
    }
}
