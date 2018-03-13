package step05.assignment;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("직삼각형의 밑변 길이는? ");
        int len = keyScan.nextInt();
        //System.out.println(length);
        int count = 1;
        while (count <= len) {
            int starCnt = 1;
            while (starCnt <= count) {
                System.out.print("*");
                starCnt++;
            }
            System.out.println();
            count++;
        }
    }
}