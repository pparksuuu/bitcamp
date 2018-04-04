// 추상 메서드
package step15.ex01;

public abstract class A4 {
    //추상 클래스의 용도는 서브 클래스들이 가져야할 공통 변수나 메서드를 제공하는 것이다
    // 그래서 일반 변수나 메서드를 정의할 수 있다.
    public static int value1;
    public int value2;
    
    static void m0() {}
    public void m1() {}
    private void m2() {}
    
    // 추상 클래스는 추상 메서드도 가질 수 있다.
    // 의미?
    // => 서브클래스마다 구현이 다를 경우 굳이 수퍼클래스에서 정의할 필요가 없기 때문에
    //    완전히 정의하지 않은 추상 메서드로 남겨둔다.
    // => 서브클래스에게 메서드 구현을 강제하고 싶을 때도 추상 메서드를 활용한다
    //    서브 클래스가 상속 추상 메서드를 구현하지 않는다면
    //    추상 메서드를 그냥 보유하기 때문에 일반 클래스로 사용할 수 없다.
    //    즉 추상 클래스가 되어야 한다.
    
    
    public abstract void m3();
    
    //public abstract void m2() {} // 컴파일 오류
}
