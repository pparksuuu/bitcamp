// 기존의 클래스를 손대지 않고 새 기능만 추가한다.
// 어떻게? 상속 문법을 이용한다.
package step11.ex05;

// 상속
// => 재사용할 기존 클래스를 지정한다.
// => 새 클래스에는 추가할 기능을 덧붙인다.
// 주의!
// => A 클래스의 코드를 자동으로 가져오는 것이 아니다.
// => B 클래스는 A 클래스의 링크 정보만 갖고 있다.
// => 따라서 B 클래스를 사용하려면 반드시 A 클래스가 있어야 한다.
public class B extends A{
    // 인스턴스 변수 추가
    int v2;
    
    static {
        System.out.println("B클래스의 static{} 실행");
    }
}  
