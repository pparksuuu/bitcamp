// 게시물 관리 - 목록 + PreparedStatement
package step25.ex8;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_list {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step25/ex8/application-context.xml");

        BoardDao boardDao = iocContainer.getBean(BoardDao.class);

        List<Board> list = boardDao.selectList();

        for(Board board :list) {
            System.out.printf("%d,%s,%s\n", 
                    board.getNo(),board.getTitle(), board.getRegisteredDate());
        }
    }
}