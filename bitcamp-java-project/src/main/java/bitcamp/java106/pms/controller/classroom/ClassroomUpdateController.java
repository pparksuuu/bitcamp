// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/classroom/update")
public class ClassroomUpdateController implements Controller {
    ClassroomDao classroomDao;

    public ClassroomUpdateController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();

        Classroom updateClassroom = new Classroom();
        updateClassroom.setNo(Integer.parseInt(request.getParameter("no")));
        updateClassroom.setTitle(request.getParameter("title"));
        updateClassroom.setStartDate(new Date(System.currentTimeMillis()));
        updateClassroom.setEndDate(new Date(System.currentTimeMillis()));
        updateClassroom.setRoom(request.getParameter("room"));

        Classroom classroom = classroomDao.get(updateClassroom.getNo());

        if (classroom == null) {
            System.out.println("유효하지 않은 수업 번호입니다.");
        } else {
            int index = classroomDao.indexOf(updateClassroom.getNo());
            classroomDao.update(index, updateClassroom);
            out.println("변경하였습니다");
        }
    }
}


//ver 26 - ClassroomController에서 update() 메서드를 추출하여 클래스로 정의.
