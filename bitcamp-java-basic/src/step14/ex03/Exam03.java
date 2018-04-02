// 다중 인터페이스 구현
package step14.ex03;

// A{m1()}, B{m2()}, C{m3()}, D{m2(),m4()}
// B 인터페이스 입장에서도 Exam03은 m2()메서드를 만든 것이고,
// D 인터페이스 입장에서도 Exam03은 m2()에서드를 만든 것이기 때문에 상관 없다.
// 왜? 어차피 구현된 메서드가 아니기 때문이다
public class Exam03 implements B, C, D {
    public void m1() {} // B의 수퍼 인터페이스인 A 인터페이스 구현
    public void m2() {} // B와 D 인터페이스 구현
    public void m3() {} // C의 인터페이스 구현
    public void m4() {} // D의 인터페이스.

}
