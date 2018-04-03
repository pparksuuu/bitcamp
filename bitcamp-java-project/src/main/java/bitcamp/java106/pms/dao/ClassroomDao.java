package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Classroom;

public class ClassroomDao<E> extends AbstractDao<E> {

    public int indexOf(Object key) {
        int no = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            Classroom classroom = (Classroom) collection.get(i);
            if (classroom.getNo() == no) {
                return i;
            }
        }
        return -1;
    }
}

//ver 20 - 클래스 추가




