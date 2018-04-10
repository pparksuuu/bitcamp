// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.util.Console;

//ClassroomController는 Controller 규칙을 이행한다.
//=> Controller 규칙에 따라 메서드를 만든다.
@Component("classroom/delete")
public class ClassroomDeleteController implements Controller {
    Scanner keyScan;

    ClassroomDao classroomDao;
    
    public ClassroomDeleteController(Scanner scanner, ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
        this.keyScan = scanner;
    }
    
    public void service(String menu, String option) {
        System.out.println("[수업 정보 삭제]");

        System.out.print("삭제할 수업 번호? ");
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        int i = Integer.parseInt(str);
        Classroom classroom = classroomDao.get(i);
        
        if (classroom == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                classroomDao.delete(i);
                System.out.println("삭제하였습니다.");
            }
        }
    }

}

//ver 22 - ClassroomDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 20 - 클래스 추가
