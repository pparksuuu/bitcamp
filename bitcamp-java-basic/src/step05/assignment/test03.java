package step05.assignment;

import java.util.Scanner;

public class test03 {
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


        //내 코드
        //int space = len;

        // while (count <= len) {
            
        //     int spaceCnt = 1;
        //     while (spaceCnt <= space/2) {
        //         System.out.print(" ");
        //         spaceCnt++;
        //     }
        //     space -= 2;
        //     int starCnt = 1;
        //     while (starCnt <= count) {

        //         System.out.print("*");
        //         starCnt++;
        //     }
        //     System.out.println();
        //     count += 2;
        // }






    }
}