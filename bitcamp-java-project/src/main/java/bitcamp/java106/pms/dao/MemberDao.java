package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    Member[] members = new Member[1000];
    int memberIndex = 0;
    
    public int getMemberIndex(String id) {
        for (int i = 0; i < this.memberIndex; i++) {
            if (this.members[i] == null) continue;
            if (id.equals(this.members[i].id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public void insert(Member member) {
        members[memberIndex++] = member;
    }
    
    public Member[] list() {
        Member[] arr = new Member[memberIndex];
        for (int i = 0; i < this.memberIndex; i ++) {
            arr[i] = members[i];
        }
        return arr;
    }
    
    public Member get(String id) {
        for (int i = 0; i < this.memberIndex; i++) {
            if (this.members[i] == null) continue;
            if (id.equals(this.members[i].id.toLowerCase())) {
                return members[i];
            }
        }
        return null;
    }
    
    public void update(Member member, Member updateMember) {
        int i = getMemberIndex(member.id);
        members[i] = updateMember;
    }
    
    public void delete(Member member) {
        int i = getMemberIndex(member.id);
        members[i] = null;
    }
    
}
