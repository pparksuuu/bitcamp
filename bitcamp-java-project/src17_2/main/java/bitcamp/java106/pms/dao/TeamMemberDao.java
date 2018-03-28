package bitcamp.java106.pms.dao;

public class TeamMemberDao {
    
    private Object[][] teamMembers = new Object[1000][2];
    private int rowIndex;
    
    private int getIndex(String teamName, String memberId) {
        String ptn = teamName.toLowerCase();
        String pmi = memberId.toLowerCase();
        for (int i = 0; i < this.rowIndex; i++) {
            if (this.teamMembers[i][0] == null) continue;
            
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            String mi = ((String)this.teamMembers[i][1]).toLowerCase();
            if (tn.equals(ptn) && mi.equals(pmi)) {
                return i;
            }
        }
        return -1;
    }
    
    public int addMember(String teamName, String memberId) {
        int index = this.getIndex(teamName, memberId);
        if (this.isExist(teamName, memberId)) {
            return 0;
        }
        this.teamMembers[rowIndex][0] = teamName;
        this.teamMembers[rowIndex][1] = memberId;
        rowIndex++;
        return 1; //한 개를 추가했다.
    }
    
    public int deleteMember(String teamName, String memberId) {
        int index = this.getIndex(teamName, memberId);
        if (!this.isExist(teamName, memberId)) {
            return 0;
        }
        
        this.teamMembers[index][0] = null;
        this.teamMembers[index][1] = null;
        return 1;
    }
    
    public boolean isExist(String teamName, String memberId) {
        if (this.getIndex(teamName, memberId) < 0) {
            return false;
        } else {
            return true;
        }
    }

    private int getMemberCount(String teamName) {
        int cnt = 0;
        String ptn = teamName.toLowerCase();
        
        for (int i = 0; i < this.rowIndex; i++) {
            if (this.teamMembers[i][0] == null) 
                continue;
            
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            if (tn.equals(ptn)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    // Method 
    public String[] getMembers(String teamName) {
        String ptn = teamName.toLowerCase();
        String[] members = new String[this.getMemberCount(teamName)];
        
        for (int i = 0, x = 0; i < this.rowIndex; i++) {
            
            if (this.teamMembers[i][0] == null) 
                continue;
            
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            
            if (tn.equals(ptn)) {
                members[x++] = (String)this.teamMembers[i][1];
            }
        }
        return members;
    }
}

