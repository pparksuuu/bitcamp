//문자 변수 - UTF-16(Unicode 2) 코드
package step02;

public class Exam06_3 {
  public static void main(String[] args) {

    int a = 0xac00;
    System.out.println(a); //a 메모리의 종류가 int이기 때문에 
                           //그냥 10진수 정수 값을 출력한다.
    
    System.out.println((char)a);

    for(int i = 0; i < 100; i++) {
      //System.out.print(('가' + i));  -> 문자 코드 값이다.
      if((i % 10) == 0) {
        System.out.println();
      }
      System.out.print((char)('가' + i)); //4432 + i
    }

  }
}

