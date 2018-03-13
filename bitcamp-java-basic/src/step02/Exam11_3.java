//변수의 중복
package step02;

public class Exam11_3
 {
  int a; //인스턴스 변수
  //static int b; //클래스 변수

  //클래스 블록 안에 선언된 변수는 종류에 상관 없이 
  //중복 선언 불가!
  //int b; //컴파일 오류!   
  //int 
  //static int a ; //컴파일 오류//컴파일 어류!

  public static void main(String[] args/*로컬변수=파라미터*/) {
    int c; //로컬 변수
    int b;

    String a; //데이터 타입에 상관 없이 이름 블록 중복 불가!
  }

  public static void m2() {
    //static이 붙은 메서드(스태틱 메서드=클래스 메서드)에서는
    //그 블록 바깥 쪽에 있는 스태틱 변수(클래스 변수)를 사용할 수 있다.
    b = 20;
    
    int a;
    int b;

    //그러나 static이 붙지 않은 인스턴스 변수는 사용할 수 없다.
    //a = 100; //컴파일 오류!
  }

  public void m3() {
    //static이 붙지 않은 블록(인스턴스 블록)에서는
    //그 블록 바깥 쪽에 선언된 변수를 모두 접근할 수 있다.
    b = 20;
    a = 100;//OK
  }

  public void m4() {

    b = 20;//ok
    a = 100;//Oka
  }
}
