// IoC 컨테이너 만들기 - 의존 객체 자동 주입
package step19.ex08;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import step19.ex05.ApplicationContext6;

public class Exam14 {
    public Exam14() {
        System.out.println("====> Exam14()");
    }
    public static void main(String[] args) throws Exception {
        ApplicationContext9 iocContainer = new ApplicationContext9("step19.ex08");
        Car2 car2 = (Car2) iocContainer.getBean("step19.ex08.Car2");
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
