package bitcamp.java106.pms; //java가 root folder이기 때문임.

//import bitcamp.java106.pms.projectTeam;

public class App {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        //projectTeam p1 = new projectTeam();

        projectTeam[] arr = new projectTeam[5];

        int count = 0;
        String a;
        
        while(count<5) {

            arr[count] = new projectTeam();

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