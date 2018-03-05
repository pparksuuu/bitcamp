//논리값 변수 - 유효한 값 범위
package step02;

public class Exam07_1 {
  public static void main(String[] args) {
    boolean b1, b2;
    b1 = true; //실제 메모리에는 1을 저장한다.
    b2 = false; //실제 메모리에는 0을 저장한다.
    
    System.out.println(b1);
    System.out.println(b2);

    //true,false대신에 1,0값을 저장하려 해서는 안된다.
    //b1 = 1; //컴파일 오류(c에선 0,1로 되지만 java에선 true,false가 명확하게 존재)
    //b2 = 2;
  }
}