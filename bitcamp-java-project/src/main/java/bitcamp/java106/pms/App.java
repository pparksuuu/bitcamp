package bitcamp.java106.pms; //java가 root folder이기 때문임.

//컴파일러에게 클래스의 위치 정보를 알려준다.
//=>컴파일한 후 import 명령은 제거된다. -> .class 파일에 포함 x.
//=>그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정말라!
import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

//4단계: 조건문 적용
public class App {
    public static void main(String[] args) {

        Scanner keyScan = new Scanner(System.in);

        Team[] teams = new Team[100];

        int count = 0;
<<<<<<< HEAD
        for(int i = 0; i < teams.length; i++) {
            count++;
            teams[i] = new Team();
        
=======
        String a;
        
        while(count<5) {

            arr[count] = new projectTeam();

>>>>>>> 41991c08d90b707739b593dcb5baa91bd1a9244e
            System.out.print("팀명? ");
            teams[i].teamName = keyScan.nextLine();

            System.out.print("설명? ");
            teams[i].description = keyScan.nextLine();

            System.out.print("최대인원? ");
            teams[i].maxQty = keyScan.nextInt();
            keyScan.nextLine();

            System.out.print("시작일? ");
            teams[i].startDate = keyScan.nextLine();

            System.out.print("종료일? ");
<<<<<<< HEAD
            teams[i].endDate = keyScan.nextLine();

            if(count == teams.length) {
                break;
            }
            
            System.out.print("계속하시겠습니까?(Y/n)");
            String str = keyScan.nextLine();
            if(str.toLowerCase().equals("n")) {
=======
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
>>>>>>> 41991c08d90b707739b593dcb5baa91bd1a9244e
                break;
            }
        }

        System.out.println("=====================");

        for(int i = 0; i < count; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n",
            teams[i].teamName, teams[i].maxQty,
            teams[i].startDate, teams[i].endDate);
        }

    }
}