package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.ArrayList;

public class TeamDao {
    private ArrayList collection = new ArrayList();
    
    public void insert(Team team) {
        collection.add(team);
    }
    
    public Team[] list() {
        Team[] arr = new Team[this.collection.size()];
        for (int i = 0; i < this.collection.size(); i++) 
            arr[i] = (Team) collection.get(i);
        return arr;
    }
    
    public Team get(String name) {
        
        //int i;
        //if ((i = this.getTeamIndex(name)) != -1)
        //    return (Team) collection.get(i);
        //return null;
        
        int index = this.getTeamIndex(name);
        if (index < 0) {
            return null;
        }
        return (Team) collection.get(index);
    }
    
    public void update(Team team) {
        int index = getTeamIndex(team.getName());
        if (index < 0)
            return;
        collection.set(index, team);
    }
    
    public void delete(String name) {
        
        //int i;
        //if ((i = this.getTeamIndex(name)) != -1)
        //    collection.remove(i);
        
        int index = this.getTeamIndex(name);
        if (index < 0)
            return;
        collection.remove(index);
    }
    
    private int getTeamIndex(String name) {
        for (int i = 0; i < collection.size(); i++) {
            if (name.toLowerCase().equals(
                    ((Team) collection.get(i)).getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}

//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





