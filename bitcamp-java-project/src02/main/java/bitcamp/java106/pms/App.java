package bitcamp.java106.pms; //java가 root folder이기 때문임.

public class App {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard);


        //String teamName, description, startDate, endDate;
        //int maxQty=0;

        System.out.print("팀명? ");
        String teamName = KeyScan.nextLine();

        System.out.print("설명? ");
        String description = KeyScan.nextLine();

        System.out.print("최대인원? ");
        int maxQty = KeyScan.nextInt();
        KeyScan.nextLine(); //숫자 뒤에 줄바꿈 코드를 읽는다.
                            //일고 난 뒤에 아무것도 안하기 때문
                            //일종의 줄바꿈 코드를 제거하는 효과가 있다.
        System.out.print("시작일? ");
        String startDate = KeyScan.nextLine();        
                    
        System.out.print("종료일? ");
        String endDate = KeyScan.nextLine();
                    
        
        /*내 코드 next() 사용.
        //nextInt에 값을 넣고 친 엔터 키 값이 시작일의 nextLine()으로 들어가버림.
        //-> next()로 개행문자/공백을 무시하고 입력을 받는다.
        System.out.print("시작일? ");
        String startDate = KeyScan.next();        

        System.out.print("종료일? ");
        String endDate = KeyScan.next();
        */
        System.out.println("=====================");
        System.out.println("팀명: " + teamName);
        System.out.println("설명: \n" + description);
        System.out.println("최대인원: " + String.valueOf(maxQty) + "명");
        System.out.println("일자: " + startDate + " ~ " + endDate);

        
        
        



    }
}