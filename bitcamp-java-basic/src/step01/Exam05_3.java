//정수의 리터럴(literal) 3 - 크기
package step01;
public class Exam05_3 {
    public static void main(String[] args) {

        //정수 표기할 때 -4바이트 크기의 정수
       System.out.println(2147483647); //4바이트 양의 정수 최대값. (0은 뺀 것.)
       System.out.println(-2147483648); //4바이트 음의 정수 최소값
       
       //4바이트 초과하면 컴파일 오류이다. -> 숫자가 1 증가하면 메모리가 넘치기 때문
       //System.out.println(2147483648); //4바이트 양의 정수 최대값. (0은 뺀 것.)
       //System.out.println(-2147483649); //4바이트 음의 정수 최소값
       
       //해결 -> 4바이트 메모리보다 더 큰 메모리로 숫자를 저장하라고 명령을 내려
       //숫자 뒤에 L 또는 l -보통 대문자. 소문자 l은 숫자 1 과 헷갈림
       System.out.println(2147483648L);
       System.out.println(-2147483649L);

       //8바이트의 정수 최대값 및 최소값 - 자바 명령어 있음
       System.out.println(Integer.MAX_VALUE); //4바이트로 표현할 수 있는 정수 최대값
       System.out.println(Integer.MIN_VALUE); //4바이트로 표현할 수 있는 정수 최소값
       System.out.println(Long.MAX_VALUE); //8바이트로 표현할 수 있는 정수 최대값
       System.out.println(Long.MIN_VALUE); //8바이트로 표현할 수 있는 정수 최소값

       //따라서 다음은 크기가 다른 정수이다.
       System.out.println(100);  //4바이트 크기의 정수 값
       System.out.println(100L); //8바이트 크기의 정수 값

    }
}





