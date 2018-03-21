package step09.assignment;

import java.util.Calendar;
import java.util.Scanner;

public class test01 {
        
        
        public static String day(int date) {
            if (date == 1)
                return "월요일";
            else if (date == 2)
                return "화요일";
                      
        }
        
        public static void main(String[] args) {
            
            Scanner keyScan = new Scanner(System.in);
            
            System.out.print("년, 월, 일?(예: 2018 3 21)> ");
            int year = keyScan.nextInt();
            int month = keyScan.nextInt();
            int date = keyScan.nextInt();
            
            Calendar c = Calendar.getInstance();
            c.set(year, month -1, date);
            
            System.out.println("요일: ");
            System.out.printf("주차: %s주차\n",day(c.get(Calendar.WEEK_OF_MONTH));
            System.out.println("일차: %s일차\n");
            
            
            
            
            
            
            
            
            
            //상수의 활용
            System.out.println(c.get(Calendar.YEAR)); //년도
            System.out.println(c.get(Calendar.MONTH) + 1); //월(0 ~ 11)
            System.out.println(c.get(Calendar.DATE)); //일
            System.out.println(c.get(Calendar.DAY_OF_WEEK)); //요일(1 ~ 7)
            System.out.println(c.get(Calendar.WEEK_OF_MONTH)); //그 달의 몇 번째 주
            System.out.println(c.get(Calendar.HOUR)); //시(0 ~ 11)
            System.out.println(c.get(Calendar.HOUR_OF_DAY)); //시(24시)
            System.out.println(c.get(Calendar.MINUTE)); //분
            System.out.println(c.get(Calendar.SECOND)); //초
            
            // Calendar c = Calendar.set(년,월,일);
        }
}
