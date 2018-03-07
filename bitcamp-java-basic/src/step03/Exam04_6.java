// 클래스 사용 - import 3
package step03;


public class Exam04_6 {
  public static void main(String[] args) {
    //다음 클래스는 패키지명을 명시하지 않아도
    //컴파일 오류가 발생하지 않는다. (자바에서 기본 제공)
    Integer obj1;
    System obj2;

    //다음 클래스도 자바에서 기본으로 제공하는 클래스
    //but 얘는 패키지명을 명시하지 않으면 컴파일 오류
    //File obj3; //컴파일 오류.
  }
}

/**
이유?
 - java.lang 패키지 -> 자바에서 가장 많이 사용하는 클래스(패키지명 명시 X)
 - 그 외 -> 반드시(패키지명 명시 O)
   지정하기 싫으면 import 명령으로 소스 파일 서두에 선언.
 */