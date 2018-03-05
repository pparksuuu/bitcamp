//형변환 - 메모리 크기가 다른 변수의 값 저장할 때
package step02;
public class Exam08_1 {
  public static void main(String[] args) {
    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100;
    char c = 100;
    
    byte b2;
    short s2;
    int i2;
    long l2;
    char c2;

    //큰 메모리 -> 작은 메모리 (X)
    //=> 컴파일 오류!
    b2 = s;
    s2 = i;
    i2 = l;
    c2 = s; //같은 2바이트라도 유효한 값의 범위가 다르다
            //char(0 ~ 65535), short(-32768 ~ 32767)
    
  }
}