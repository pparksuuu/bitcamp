package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Team {
    public String name;
    public String description;
    public int maxQty;
    public Date startDate;
    public Date endDate;
    public Member[] members = new Member[10];
    
    public boolean isExist(String id) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) continue;
            if (id.equals(this.members[i].id)) {
                return true;
            }
        }
        return false;
    }
    
    public int memberAdd(Member member) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] != null) continue;
            this.members[i] = member;
            return 1;
        }
        return 0;
    }
    
    public int memberDelete(Member member) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) continue;
            if(member.id.equals(this.members[i].id)) {
                this.members[i] = null;
                return 1;
            }
        }
        return 0;
    }
}