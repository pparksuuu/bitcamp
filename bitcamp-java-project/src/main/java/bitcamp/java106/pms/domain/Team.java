package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Team {
    public String name;
    public String description;
    public int maxQty;
    public Date startDate;
    public Date endDate;
    public Member[] members = new Member[10];
}

// ver 15 - 멤버를 저장할 인스턴스 변수를 추가한다.