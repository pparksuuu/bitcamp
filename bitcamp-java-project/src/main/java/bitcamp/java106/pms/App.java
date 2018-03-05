package bitcamp.java106.pms; //java가 root folder이기 때문임.

public class App {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard);


        String team, des, s_date, f_date;
        int MAX=0;
        System.out.print("팀명? ");
        team = KeyScan.nextLine();
        System.out.print("설명? ");
        des = KeyScan.nextLine();
        System.out.print("최대인원? ");
        MAX = KeyScan.nextInt();

        //nextInt에 값을 넣고 친 엔터 키 값이 시작일의 nextLine()으로 들어가버림.
        //-> next()로 개행문자/공백을 무시하고 입력을 받는다.
        System.out.print("시작일? ");
        s_date = KeyScan.next();             
        System.out.print("종료일? ");
        f_date = KeyScan.next();

        System.out.println("=====================");
        System.out.println("팀명: " + team);
        System.out.println("설명: " + des);
        System.out.println("최대인원: " + String.valueOf(MAX) + "명");
        System.out.println("일자: " + s_date + " ~ " + f_date);

        
        
        



    }
}