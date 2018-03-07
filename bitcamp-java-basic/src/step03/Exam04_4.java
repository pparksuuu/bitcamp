// 클래스 사용 - import
package step03;

//import는 package선언 다음에 두어야 한다.
import step03.test.B;


public class Exam04_4 {
  public static void main(String[] args) {
    //다른 패키지의 클래스 사용
    //=> 패키지 이름을 항상 붙여야 한다.
    // 그래야만 컴파일러가 해당 클래스를 찾을 수 있다.
    B v1;
    v1 = new B();
  }
}
