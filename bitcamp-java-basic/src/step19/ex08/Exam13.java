// IoC 컨테이너 만들기 - 의존 객체의 주입
package step19.ex08;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import step19.ex05.ApplicationContext6;

public class Exam13 {
    public static void main(String[] args) {
        // 새 Engine을 준비한다.
        UltraEngine engine = new UltraEngine();
        
        // Car 클래스는 Engine을 자체적으로 생성하여 사용하기 때문에
        // 새로 만든 엔진을 꼽을 수가 없다.
        Car car = new Car(); //기존의 Engine 객체 사용
        car.move();
        
        System.out.println("=======================");
        // Car2 클래스는 외부에서 Engine 객체를 주입받도록 설계했지 때문에
        // 새 UltraEngine을 장착할 수 있다.
        Car2 car2 = new Car2(engine);
        car2.move();
    }
}

// DI는 IoC의 한 예이다.
//
// IoC(Inversion of Control)?
// => 제어의 역행
// => 일반적인 흐름에서 벗어난 동작을 말한다.
// => 예: 
//    1) Dependency Injection(DI)
//       => 자신이 사용할 의존 객체를 자신이 만들지 않고 외부에서 주입받는 것.
//    2) Event
//       => 실행 순서에 상관없이 특정 사건이 발생하면 지정된 코드가 실행되는 것.
