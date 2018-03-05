//부동 소수점 변수 - 단정도와 배정도
package step02;

public class Exam05_2 {
  public static void main(String[] args) {
    float f;
    double d;

    // 다음 코드의 값은 4바이트 크기의 부동소수점을 저장하는 것.
    //변수(메모리)에 값을 넣기 전에
    //이미 리터럴 값이 4바이트 크기를 넘어가기 때문에 짤린다.
    f = 9876.98769876f;
    d = 9876.98769876f;

    System.out.println(f);
    System.out.println(d);


    //double(8byte) 값-> float(4byte) 메모리
    f = 9876.98769876; //컴파일 오류!
    //double 메모리에 리터럴 값을 넣을 때는
    //8바이트 부동소수점 리터럴을 넣어라 ! 
    //즉 리터럴 뒤에 f나 F를 붙이지 말라 !
    d = 9876.98769876;
    
    System.out.println(f);
    System.out.println(d);
    
  }
}