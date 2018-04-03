package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Classroom;

public class ClassroomDao extends AbstractDao<Classroom> {
    
    public int indexOf(Object key) {
        int no = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            if ( collection.get(i).getNo() == no) {
                return i;
            }
        }
        return -1;
    }
}
