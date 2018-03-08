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
        
        }
    }