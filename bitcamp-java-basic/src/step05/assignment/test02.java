package step05.assignment;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("마름모 한 변의 길이는? ");
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

        count = len - 1;
        while (count >= 1) {
            int starCnt = 1;
            while (starCnt <= count) {
                System.out.print("*");
                starCnt++;
            }
            System.out.println();
            count--;
        }
    }
}