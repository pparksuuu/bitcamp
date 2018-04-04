// 추상 클래스와 추상 메서드
package step15.ex01;

// 추상 메서드는 구현하지 않은 메서드이기 때문에 
// 일반 클래스(=구현 클래스; conctrete class)는 추상 메서드를 가질 수 없다.
// 오직 추상 클래스만이 추상 메서드를 가질 수 있다.
public abstract class A3 {
    //추상 메서드는 구현할 수 없다.
    public abstract void m1();
    
    //public abstract void m2() {} // 컴파일 오류
}
