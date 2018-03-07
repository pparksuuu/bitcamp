// 클래스 사용 - import 2
package step03;

//패키지명 + wildcard(*) -> 그 패키지의 모든 클래스 사용 가능
import step03.test.*;
import java.util.*;
import java.lang.reflect.*;


public class Exam04_5 {
  public static void main(String[] args) {
    B v1;
    v1 = new B();

    Method obj1;
    Calendar obj2;

  }
}

/**
 결론!
 - 가능한 import문 선언 때 * 대신 구체적인 클래스명 적어라 !
 - 같은 패키지의 여러 클래스를 사용하더라도, 
 - 구체적인 클래스명 적어라 !
 */
