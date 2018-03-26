// 캡슐화(encapsulation) - 필요한 이유
package step11.ex13;

import step11.ex13.sub.B;
import step11.ex13.sub.C;

public class Exam02_1 extends C {
    
    public static void main(String[] args) {
        A obj1 = new A();
        
        //obj1.privateVar = 100; //접근 불가! 오직 그 클래스 안에서만 사용 가능.
        obj1.defaultVar = 100; //OK ! 이 클래스는 A 클래스와 같은 패키지에 소속되어 있다.
        obj1.protectedVar = 100; //OK ! 비록 이 클래스가 자식 클래스는 아니지만
                                 //같은 패키지에 소속되어 있다.
        obj1.publicVar = 100;
        
        B obj2 = new B();
        //obj2.privateVar = 100; //접근 불가 ! 오직 그 클래스 안에서만 사용 가능.
        //obj2.defaultVar = 100; //접근 불가 ! 같은 패키지까지 접근 가능
        //obj2.protectedVar = 100; //접근 불가 ! 같은 패키지, 자식까지 접근 가능
        obj2.publicVar = 100; //모두가 접근 가능 !
        
        C obj3 = new C();
        //obj3.privateVar = 100; //접근 불가 ! 오직 그 클래스 안에서만 사용 가능.
        //obj3.defaultVar = 100; //접근 불가 ! 같은 패키지까지 접근 가능
        //obj3.protectedVar = 100; //자식이라 접근 가능 !
                                 //자식 클래스인데 접근 불가!?
                                 //이유 => 자기의 인스턴스 변수가 아니다. 
        obj3.publicVar = 100; //모두가 접근 가능 !
        
        Exam02_1 obj4 = new Exam02_1();
        //obj4.privateVar = 100;// 접근 불가 ! C 클래스에서만 접근 가능
        //obj4.defaultVar = 100;
        obj4.protectedVar = 100; //상속 받아서 만든 것만 접근 가능.
        obj4.publicVar = 100;
    }
}

// 실무
// => 인스턴스 변수는 보통 private으로 접근 제한
// => 겟터, 셋터는 public으로 접근을 모두에게 공개
// => 일반 메서드도 public으로 접근을 모두에게 공개한다.
// => 그 클래스 내부에서만 사용되는 private으로 접근을 제한한다.
// => 자식 클래스의 접근을 허용할 필요가 있을 경우에만 protected로 만든다.

