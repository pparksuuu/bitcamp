//흐름 제어문 - for 반복문의 초기화 변수
package step05;

import java.util.Scanner;

public class Exam04_2 {
    public static void main(String[] args) {
        //for문 안에 선언된 변수는 of문을 나가는 순간 제거된다.
        for(int i =1; i <= 5; i++)
            System.out.println(i);

        System.out.println("=====================");

        //반복문을 종료한 뒤에도 해당 변수의 값을 사용하고 싶으면,
        //다음과 같이 반복문 밖에 변수를 선언하라

        int x;
        for(x = 1; x <= 5; x++) 
            System.out.println(x);
        System.out.printf("x = %d\n", x);
        
    }
}