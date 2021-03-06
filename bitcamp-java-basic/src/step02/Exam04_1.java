// 정수 변수 - 정수 리터럴과 정수 변수
package step02;

public class Exam04_1 {
    public static void main(String[] args) {
      byte b;
      //정수 리터럴은 기본이 4바이트 메모리를 차지한다.
      //그런데 byte 메모리에 저장할 수 있는 값이라면 허락한다.
      b = -128;
      b = 127;
      
      //다음과 같이 4바이트 리터럴 값을 메모리에 넣을 수 없다면,
      //컴파일 오류가 발생한다 !
      b = -129; //컴파일 오류 !
      b = 128;

      short s;
      //4바이트 정수 리터럴을 short 메모리(2byte)에 저장할 수 있다면 허락
      s = -32768;
      s = 32767;

      //만약 2바이트 범위를 벗어난다면 컴파일 오류!
      s = -32769;
      s = 32768;
      
      int i;
      i = -2147483648;
      i = 2147483647;

      //다음은 메모리의 문제가 아니다. 
      //정수 값을 표현할 때 4바이트 크기를 넘어가는 수를 표현했기 때문에
      //오류가 발생한 것이다.
      //4바이트 크기를 넘어가는 정수를 표현할 때는 
      //반드시 숫자 뒤에 L 또는 l을 넣어야 한다.
      //i = -2147483649;
      //i = 2147483649;

      //다음은 4바이트가 넘어가는 수에 대해 L 또는 l을 붙임으로써
      //정수 리터럴을 잘 표현했다.
      //그러나 i 메모리가 4바이트 크기를 갖기 때문에
      //오른쪽의 값을 모두 저장할 수 없다.그래서 컴파일 오류가 발생한다.
      i = -2147483649L;
      i = 2147483649L;      
      
      long l;
      l = -9223372036854775808L;
      l = 9223372036854775807L;

      byte b2;
      b2 = 100; //OK
      b2 = 100L; //컴파일 오류!
      //4바이트 정수 리터럴에 대해서만 
      //byte나 short 메모리에 유효한 범위의 값을 저장할 수 있게 허락한다.
      //8바이트 정수 리터럴일 경우에는
      //비록 byte나 short메모리에 저장할 수 ㅣㅇㅆ는 값이라도 허락하지 않는다.
      //컴파일 오류


    }
}

/**
변수
 - 값을 저장할 메모리를 준비시키는 명령.
문법
 - 메모리종류 별명;
메모리 종류 
1) Primitive data type(원시 데이터 타입)
자바에서 기본으로 제공하는 메모리 종류 
 - 정수
   - byte : 1byte 메모리 (-128 ~ 127)
   - short : 2yte 메모리 (-32768 ~ 32787)
   - int : 4byte 메모리 (약 -21억 ~ 21억)
   - long : 8byte 메모리 (약 -922경 ~ 922경)
 - 부동소수점
   - float : 4byte 메모리 (유효자릿수 7자리)
   - double : 8byte 메모리 (유호자릿수 15자리)
 - 문자
   - char : 2byte 메모리 (0 ~ 65535 - unsigned이기 때문) , UTF-16 코드 값 저장.
 - 논리값
   - boolean : JVM에서 4byte 메모리를 사용한다.

2) Reference(레퍼런스)
데이터가 저장된 메모리의 주소를 저장하는 메모리
 - 문자열(주소)
   - String : 문자열이 저장된 주소를 저장한다.
              지금 당장은 그냥 문자열을 저장하는 메모리로 생각.
*/