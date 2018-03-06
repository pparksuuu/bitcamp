//형변환 - 명시적 형변환 2
package step02;
public class Exam08_6 {
  public static void main(String[] args) {
    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100;

    //큰 메모리의 값을 작은 메모리에 저장하는 경우
    //=> 작은 메모리에 들어갈 수 있는 값인 경우에 형변환을 해야한다.
    //s(100)는 byte메모리에 충분히  들어갈 수 있는 값.
    byte b2 = (byte)s;//명시적 형변환
    System.out.println(b2);
    
    b2 = (byte)i;
    System.out.println(b2);
    
    b2 = (byte)l;
    System.out.println(b2);

    //=> 작은 메모리에 들어갈 값 보다 큰 값을
    //명시적 형변환을 수행하여 값을 넣으려 하면 
    //값이 짤린다.

    int i2 = 300; //0b0000_0000_0000_0000_0000_0001_0010_1100; //300(10진수)
    b2 = (byte)i2; //
    System.out.println(b2); //0b0010_1100
    /*
    큰 값을 작은 메모리에 넣는 것은 아무 의미도 없다.
     */
    
    
  }
}