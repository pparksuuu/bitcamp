// 의존 객체 주입 자동화하기 - 인스턴스 변수에 @Autowired 붙이기
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam04 {
    public static void main(String[] args) {
        // @Autowired 애노테이션을 인스턴스 변수에 붙여도 된다.
        // => 그러면 의존 객체를 직접 변수에 주입한다.
        // => 셋터를 호출하지 않는다.
        //    즉 셋터가 없어도 된다.
        // => 인스턴스 변수에 직접 의존 객체를 주입한다는 것은
        //    캡슐화, 즉 외부에서 직접 인스턴스 변수에 접근하는 것을 막는 기법,를 
        //    위배하는 측면이 있기 때문에
        //    이 방식은 "객체지향을 파괴하는 방식"이라는 비난을 받기도 한다.
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step08/application-context-04.xml");

        
        
        // Car 객체를 꺼내 Engine 객체가 주입되었는지 확인해보자!
        System.out.println(iocContainer.getBean("c1"));
    }
}
