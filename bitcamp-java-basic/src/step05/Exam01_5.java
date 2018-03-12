//흐름 제어문 - else문의 소속
package step05;

import javax.lang.model.util.ElementScanner6;

public class Exam01_5 {
    public static void main(String[] args) {
        int age = 15;

        //else는 가장 가까운 if에 소속된다.
        //들여쓰기에 속지 말라!
        if (age >= 19) 
            if (age >= 70)
                System.out.println("지하철 무임승차 가능합니다.");
        else
            System.out.println("미성년입니다.");

        if (age >= 19) {
            if (age >= 70)
                System.out.println("지하철 무임승차 가능합니다.");
            else
                System.out.println("미성년자입니다.");
        }

        if(age >= 19) {
            if(age >= 70)
                System.out.println("지하철 무임승차 가능합니다.");
        }
        else
            System.out.println("미성년자입니다.");

    }
}