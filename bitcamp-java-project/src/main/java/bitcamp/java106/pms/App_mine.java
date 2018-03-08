package bitcamp.java106.pms; //java가 root folder이기 때문임.

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App_mine {
    public static void main(String[] args) {

        Scanner keyScan = new Scanner(System.in);

        //Team p1 = new Team();

        Team[] arr = new Team[5];

        int count = 0;
        String a;
        
        while(count<5) {

            arr[count] = new Team();

            System.out.print("팀명? ");
            arr[count].teamName = keyScan.nextLine();
            System.out.print("설명? ");
            arr[count].description = keyScan.nextLine();
            System.out.print("최대인원? ");
            arr[count].maxQty = keyScan.nextInt();
            keyScan.nextLine();
            System.out.print("시작일? ");
            arr[count].startDate = keyScan.nextLine();
            System.out.print("종료일? ");
            arr[count].endDate = keyScan.nextLine();
            count++;
            //최대 인원 5명을 넘어가면 자동으로 종료
            if(count == 4) {
                break;
            }

            while(true) {
                System.out.print("계속 입력하시겠습니까?(Y/n) ");
                a = keyScan.next();
                keyScan.nextLine();
                if(a.equals("Y")) {
                    break;
                }
                else if(a.equals("n")) {
                    break;
                }
                else {
                    System.out.println("'Y'나 'n' 중 한 문자를 입력하세요.");
                }
            }

            if(a.equals("n")) {
                break;
            }
        }

        System.out.println("=====================");

        for(int i = 0; i < count ;i++) {
        System.out.printf("%s, %d명, %s ~ %s\n",arr[i].teamName, arr[i].maxQty,
        arr[i].startDate, arr[i].endDate);
        }
  

    }
}