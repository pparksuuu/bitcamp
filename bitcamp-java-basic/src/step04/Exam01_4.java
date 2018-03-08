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
        
        int x = 21_0000_0000;
        int y = 21_0000_0000;
        int r1 = x + y;
        long r2 = x + y;
        System.out.println(r1);
        System.out.println(r2);
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