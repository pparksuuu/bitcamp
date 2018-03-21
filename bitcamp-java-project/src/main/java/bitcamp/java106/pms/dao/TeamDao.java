package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    Team[] teams = new Team[1000];
    int teamIndex = 0;
    
    public void insert(Team team) {
        teams[teamIndex++] = team;
    }
    
    public int getTeamIndex(String name) {
        for (int i = 0; i < this.teamIndex; i++) {
            if (this.teams[i] == null) continue;
            if (name.equals(this.teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public Team get(String name) {
        for (int i = 0; i < this.teamIndex; i++) {
            if (this.teams[i] == null) continue;
            if (name.equals(this.teams[i].name.toLowerCase())) {
                return teams[i];
            }
        }
        return null;
    }
    
    public Team[] list() {
        Team[] arr = new Team[teamIndex];
        for (int i = 0; i < this.teamIndex; i ++) {
            arr[i] = teams[i];
        }
        return arr;
    }
    
    public void update(Team team, Team updateTeam) {
        int i = getTeamIndex(team.name);
        teams[i] = updateTeam;
    }
    
    public void delete(Team team) {
        int i = getTeamIndex(team.name);
        teams[i] = null;
    }
}
