package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.util.Console;

public class ClassroomController implements Controller {
    Scanner keyScan;
    ClassroomDao classroomDao;
    
    public ClassroomController(Scanner scanner, ClassroomDao classroomDao) {
        keyScan = scanner;
        this.classroomDao = classroomDao;
    }

        public void service(String menu, String option) {
        if (menu.equals("classroom/add")) {
            this.onAdd();
        } else if (menu.equals("classroom/list")) {
            this.onList();
        } else if (menu.equals("classroom/update")) {
            this.onUpdate();
        } else if (menu.equals("classroom/delete")) {
            this.onDelete();
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

        private void onAdd() {
            System.out.println("[수업 등록]");
            Classroom classroom = new Classroom();
            
            System.out.print("수업명? ");
            classroom.setTitle(keyScan.nextLine());
            
            System.out.print("시작일? ");
            classroom.setStartDate(Date.valueOf(keyScan.nextLine()));
            
            System.out.print("종료일? ");
            classroom.setEndDate(Date.valueOf(keyScan.nextLine()));

            System.out.print("교실명? ");
            classroom.setRoom(keyScan.nextLine());
            
            classroomDao.insert(classroom);
        }

        private void onList() {
            System.out.println("[수업 목록]");
            Classroom[] list = classroomDao.list();
            for (Classroom classroom : list) {
                System.out.printf("%d, %s, %s ~ %s, %s\n",
                        classroom.getNo(), classroom.getTitle(),
                        classroom.getStartDate(), classroom.getEndDate(),
                        classroom.getRoom());
            }
        }

        private void onUpdate() {
            System.out.println("[수업 정보 변경]");
            System.out.print("변경할 수업 번호? ");
            String str = keyScan.nextLine();
            if (str.length() == 0) {
                System.out.println("번호를 입력하시기 바랍니다.");
                return;
            }

            Classroom classroom = classroomDao.get(Integer.parseInt(str));

            if (classroom == null) {
                System.out.println("유효하지 않은 수업 번호입니다.");
                return;
            } 
            
            Classroom updateClassroom = new Classroom();
            updateClassroom.setNo(classroom.getNo());

            System.out.printf("수업명(%s)? ", classroom.getTitle());
            str = keyScan.nextLine();
            if (str.length() == 0) {
                updateClassroom.setTitle(classroom.getTitle());
            } else {
                updateClassroom.setTitle(str);
            }

            System.out.printf("시작일(%s)? ", classroom.getStartDate());
            str = keyScan.nextLine();
            if (str.length() == 0) {
                updateClassroom.setStartDate(classroom.getStartDate());
            } else {
                updateClassroom.setStartDate(Date.valueOf(str));
            }

            System.out.printf("종료일(%s)? ", classroom.getEndDate());
            str = keyScan.nextLine();
            if (str.length() == 0) {
                updateClassroom.setEndDate(classroom.getStartDate());
            } else {
                updateClassroom.setStartDate(Date.valueOf(str));

            }

            System.out.printf("교실번호(%s)? ", classroom.getNo());
            str = keyScan.nextLine();
            if (str.length() == 0) {
                updateClassroom.setRoom(classroom.getRoom());
            } else {
                updateClassroom.setRoom(str);
            }

            if(Console.confirm("변경하시겠습니까?")) {
                classroomDao.update(updateClassroom);
                System.out.println("변경하였습니다.");
            } else {
                System.out.println("취소하였습니다.");
                return;
            }
        }

        private void onDelete() {
            System.out.println("[수업 삭제]");
            
            System.out.print("삭제할 수업 번호? ");
            String str = keyScan.nextLine();
            if (str == null) {
                System.out.println("변호를 입력하시기 바랍니다.");
            }

            int index = Integer.parseInt(str);

            Classroom classroom = classroomDao.get(index);

            if (classroom == null) {
                System.out.println("유효하지 않은 수업 번호입니다.");
            } else {
                if (Console.confirm("정말 삭제하시겠습니까?")) {
                    classroomDao.delete(index);
                    System.out.println("삭제하였습니다.");
                }
            }

        }
}
