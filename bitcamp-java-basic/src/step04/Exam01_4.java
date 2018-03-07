// 산술 연산자 : 암시적 형변환
package step04;

public class Exam01_4 {
    public static void main(String[] args) {
        int i = 5;
        int j = 2;
        float r = i / j;
        System.out.println(r);
        System.out.println((int)r);
         
        }
    }