package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Team {
    public String name;
    public String description;
    public int maxQty;
    public Date startDate;
    public Date endDate;
    public Member[] members = new Member[10];
    
    //메서드 정의 
    //연산자는 외부에서 사용하는 것이기 때문에 공개해야 한다.
    //그래서 public modifier를 사용한다.
    public  int addMember(Member member) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) {
                this.members[i] = member;
                System.out.println("추가하였습니다.");
                return 1;
            }
        }
        return 0;
    }
    
    public int deleteMember(String memberId) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) continue;
            if (this.members[i].id.equals(memberId)) {
                this.members[i] = null;
                return 1;
            }
        }
        return 0;
    }
    
    public boolean isExist(String memberId) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) continue;
            if (this.members[i].id.equals(memberId)) {
                return true;
            }
        }
        return false;
    }
}

// ver 15 - 멤버를 저장할 인스턴스 변수를 추가한다.