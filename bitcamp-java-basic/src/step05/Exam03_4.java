//흐름 제어문 - do ~ while 반복문
package step05;

import java.util.Scanner;

public class Exam03_4 {
    public static void main(String[] args) {
        int i = 0;

        //1부터 10까지 출력하기
        do
            System.out.println(++i);
        while(i < 10);

        System.out.println("=====================");
        i = 0;
        do {
            i += 1;
            System.out.println(i);
        } while (i < 10);
            

    }
}