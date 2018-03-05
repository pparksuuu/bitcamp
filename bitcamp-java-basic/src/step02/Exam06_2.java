//문자 변수 - UTF-16(Unicode 2) 코드 값 저장
package step02;

public class Exam06_2 {
  public static void main(String[] args) {
    char c1, c2, c3; 

    c1 = 0x41; //A 문자의 UTF-16 코드값
    c2 = 65; // A 문자의 UTF-16 코드값
    c3 = 0b0100_0001;
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    
    char c4;
    //문자를 저장하는 변수에 저장하는 것은 UTF-16에 정의된 그 문자의 코드값이야! 
    c4 = '헐';  //헐이라는 문자 코드값이 c4에 저장되는 것이다 !
                // c4 = 54736; -> font file에서 찾아서 찍어줘


    System.out.println(c4);
    
  }
}