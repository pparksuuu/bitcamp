package bitcamp.java106.pms; //java가 root folder이기 때문임.

//컴파일러에게 클래스의 위치 정보를 알려준다.
//=>컴파일한 후 import 명령은 제거된다. -> .class 파일에 포함 x.
//=>그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정말라!
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;

//4단계: 조건문 적용
public class App_mine {
    public static void main(String[] args) {

        Scanner keyScan = new Scanner(System.in);

        Team[] teams = new Team[100];
        Member[] members = new Member[100];

        
        int tCount = 0;
        int mCount = 0;
        
        while (true) {

            System.out.println();
            System.out.print("명령> ");
            String str = keyScan.nextLine();
            //명령어를 받아와서 공백으로 구분해서 배열로 반환.
            String[] inputs = str.split(" ");
            //String[] inputs = str.split("\\s");

                if(inputs[0].equals("help")) {
                    System.out.println("팀 등록 명령 : team/add");
                    System.out.println("팀 조회 명령 : team/list");
                    System.out.println("팀 상세조회 명령 : team/view 팀명");
                    System.out.println("회원 등록 명령 : member/add");
                    System.out.println("회원 조회 명령 : member/list");
                    System.out.println("회원 상세조회 명령 : member/view 아이디");
                    System.out.println("종료 : quit");
    
                }

                else if(inputs[0].equals("team/add")) {

                    if(tCount == teams.length) {
                        System.out.println("더 이상 팀을 만들 수 없습니다.");
                    }
                    
                    else {
                        teams[tCount] = new Team();

                        System.out.print("팀명? ");
                        teams[tCount].teamName = keyScan.nextLine();
                        System.out.print("설명? ");
                        teams[tCount].description = keyScan.nextLine();
                        System.out.print("최대인원? ");
                        teams[tCount].maxQty = keyScan.nextInt();
                        keyScan.nextLine();
                        System.out.print("시작일? ");
                        teams[tCount].startDate = keyScan.nextLine();
                        System.out.print("종료일? ");
                        teams[tCount].endDate = keyScan.nextLine();
                        tCount++;
                    }
                }

                else if(inputs[0].equals("team/list")) {
                    for(int i = 0; i < tCount; i++) {
                        System.out.printf("%s, %d명, %s ~ %s\n",
                        teams[i].teamName, teams[i].maxQty,
                        teams[i].startDate, teams[i].endDate);
                    }
                    
                }

                else if(inputs[0].equals("team/view")) {
                    //3가지 경우가 있음. 
                    //if문에는 긍정의 조건을 넣어야 가독성 좋음
                    
                    if(inputs.length == 1)
                    {
                        System.out.println("팀명을 입력하시기 바랍니다.");
                    }
                    else {
                        boolean exist = false;
                        int t=0;
                        for(int i =0; i < tCount; i++) {
                            if(inputs[1].equals(teams[i].teamName))
                            {
                                t = i;
                                exist = true;
                                break;
                            }
                        }
                        if(exist == true) {
                            System.out.printf("팀명: %s\n설명:%s\n최대인원: %d명\n기간: %s ~ %s\n",
                            teams[t].teamName,teams[t].description,
                            teams[t].maxQty,
                            teams[t].startDate, teams[t].endDate);
                        }
                        else {
                            System.out.println("해당 이름의 팀이 없습니다.");
                        }
                    }
                 
                }

                else if(inputs[0].equals("member/add")) {
                    members[mCount] = new Member();

                    System.out.print("아이디? ");
                    members[mCount].id = keyScan.nextLine();
                    System.out.print("이메일? ");
                    members[mCount].email = keyScan.nextLine();
                    System.out.print("암호? ");
                    members[mCount].password = keyScan.nextLine();
                    mCount++;
                }

                else if(inputs[0].equals("member/list")) {
                    for(int i = 0; i < mCount; i++) {
                        System.out.printf("%s, %s, %s\n",
                        members[i].id, members[i].email, members[i].password);
                    }
                }

                else if(inputs[0].equals("member/view")) {
                    if(inputs.length == 1)
                    {
                        System.out.println("아이디를 입력하시기 바랍니다.");
                    }
                    else {
                        boolean exist = false;
                        int t=0;
                        for(int i =0; i < mCount; i++) {
                            if(inputs[1].equals(members[i].id))
                            {
                                t = i;
                                exist = true;
                                break;
                            }
                        }
                        if(exist == true) {
                            System.out.printf("아이디: %s\n이메일: %s\n암호: %s\n",
                            members[t].id, members[t].email,
                            members[t].password);
                        }
                        else {
                            System.out.println("해당 아이디의 회원이 없습니다.");
                        }
                    }
                }

                else if(inputs[0].equals("quit")) {
                    System.out.println("안녕히 가십시오!");
                    break;
                }

                else {
                    System.out.println("명령어가 올바르지 않습니다.");
                }

        }




    }
}