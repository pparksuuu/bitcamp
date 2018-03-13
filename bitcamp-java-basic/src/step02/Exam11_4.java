//변수의 범위 - 변수와 블록
package step02;

public class Exam11_4
 {
  public static void main(String[] args) {
    int a = 100;
    {
      //메서드 안에서는 변수 이름 중복 불가
      //안쪽 블록에서는 바깥 블록의 변수를 사용할 수 있다.
      a = 200;
      int b = 199;
       }

       System.out.println(a);

       {
         int b = 300l;
       }
  }


}
