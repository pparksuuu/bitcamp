//문자 변수 - 유효한 값 범위
package step02;

public class Exam06_1 {
  public static void main(String[] args) {
    //0 ~ 65535 까지의 UTF-16코드 값을 저장하는 변수
    char c; //char -> 문자 코드 값을 저장.

    c = 0;
    c = 65535;

    //char(2byte) 크기의 메모리 범위를 초과하면 컴파일 오류 발생!
    c = -1;
    c = 65536;




  }
}