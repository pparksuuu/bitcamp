//메소드 사용 전
package step06;

import java.util.Scanner;

public class Exam01_1 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("정삼각형 한 변의 길이는? ");
        int len = keyScan.nextInt();

        int starLen = 1;
        
        while (starLen <= len) {
            int spaceCnt = 1; 
            int spaceLen = (len - starLen) / 2;
            while (spaceCnt <= spaceLen) {
                System.out.print(" ");
                spaceCnt++;
            }

            int starCnt = 1;
            while (starCnt <= starLen) {
                System.out.print("*");
                starCnt++;
            }
            System.out.println();
            starLen += 2;
        }
    }
}