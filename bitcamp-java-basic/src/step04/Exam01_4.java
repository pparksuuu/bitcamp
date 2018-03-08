// 산술 연산자 : 암시적 형변환
package step04;

public class Exam01_4 {
    public static void main(String[] args) {
        int i = 5;
        int j = 2;
        float r = i / j; //int와 int의 연산 결과는 항상 int.
                         //따라서 r 변수에 넣기 전에 이미 결과는 정수 2.
                         //그래서 출력할 때 2.0이 된다.
        System.out.println(r);

        //해결책 ! 
        /**
         -변수에 들어 있는 값을 다른 타입으로 바꿔라.
         "형변환(type conversion = type casting)"
         */
        r = (float)i / (float)j;
        System.out.println(r);
        
        
        // int x = 21_0000_0000;
        // int y = 21_0000_0000;
        
        // int와 int의 연산 결과는 무조건 int이다.
        // 다른 타입이 될 수 없다.
        // 0111 1111 1111 1111 1111 1111 1111 1111 = Integer.MAX_VALUE
        int x = Integer.MAX_VALUE; //0x7fffffff = 약 +21억
        int y = Integer.MAX_VALUE; //0x7fffffff = 약 +21억
        int r1 = x + y; //0x7fffffff + 0x7fffffff = 0xffffffe = -2
        long r2 = x + y; //0x7fffffff + 0x7fffffff = 0xffffffe = -2
        long r3 = 0x7fffffff + 0x7fffffff;
        System.out.println(r1); //int(4byte) + int(4byte) = int(4byte)
        System.out.println(r2); //int(4byte) + int(4byte) = int(4byte)        
        System.out.println(r3); //int(4byte) + int(4byte) = int(4byte)        
        
        float f1 = 987.6543f; 
        float f2 = 1.111111f;
        float r4 = f1 + f2; //987.6543 + 1.111111 = 988.7654311
                            //float과 float의 연산 결과는 float이다.
                            //그래서 메모리 크기를 넘어가는 뒤의 11은 짤린다.
        double r5 = f1 + f2;
        System.out.println(r4);//988.7654
        System.out.println(r5);//988.765380859375

        double d1 = 987.6543;
        double d2 = 1.111111;
        double r6 = d1 + d2; //988.765411
        System.out.println(r6);

        }
    }

/**
 결론 !
 1) 자바의 최소 연산 단위는 int.
 (int보다 작은 크기의 메모리 값을 다룰 때는
 내부적으로 int로 자동 형변환을 수행한 다음에 연산 수행.)
 내부적 자동 형변환 -> "암시적 형변환(implicit type conversion)"
 => byte + byte = int
 => short + short = int
 => byte + short = int

 2)연산 결과 = 피연산자의 타입
 
 3) 다른 타입과 연산을 수행 
 내부적으로 같은 타입으로 맞춘 다음에 실행

 */