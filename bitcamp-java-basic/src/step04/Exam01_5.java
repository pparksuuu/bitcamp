// 산술 연산자 : 암시적 형변환
package step04;

public class Exam01_5 {
    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4;
        float f = 5.5f;
        double d = 6.6;
        char c = 7;
        boolean bool = true;

        //byte + byte = int
        //=>연산 수행 전에 byte -> int로 암시적 형변환.
        //byte r1 = b + b; //컴파일 오류

        //short + short = int
        //=>연산 수행 전에 short -> int로 암시적 형변환.
        //short r2 = s + s; //컴파일 오류

        //byte + short = int
        //=> byte, short => int로 암시적 형변환.
        //short r3 = b + s; //컴파일 오류

        //byte + int = int
        //=>byte -> int로 암시적 형변환
        int r4 = b + i;//OK

        //short + int = int
        //=>short -> int로 암시적 형변환
        int r5 = s + i;
        
        //int + long = long
        //=>int -> long으로 암시적 형변환
        //int r6 = i + l;//컴파일 오류

        //long + float = float
        //=> long -> float 암시적 형변환
        //long r7 = l + f;//컴파일 오류

        //int + float = float
        //int r8 = i + r; //컴파일 오류!

        //flaot + double = double
        //float r9 = f + d; //컴파일 오류!

        //byte + short + int + long + float + double = double
        //long r10 = b + s + i + l + f + d;//컴파일 오류!
        double r11 = b + s + i + l + f + d;

        //float + int + long = float
        //long r12 = f + i + l; //컴파일 오류!

        //boolean + int = zjavkdlf dhfb!
        //=> 산술 연산자는 정수 타입(byte, short, char, int, long)과
        //   부동소수점 타입(float, double)에 대해서만
        //   실행할 수 있다.
        //int r13 = bool + i;// 컴파일 오류!
    }
}

/**
 암시적 형변환 규칙
 다음과 같이 오른쪽 타입의 값으로 자동 변환시킨다.
 byte,short,char => int => long => float => double
 */



