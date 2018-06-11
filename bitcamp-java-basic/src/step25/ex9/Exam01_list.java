// 게시물 관리 - 목록 + PreparedStatement
package step25.ex9;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_list {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step25/ex9/application-context.xml");

        // 트랜잭션 적용
        // 1) 트랜잭션 관리자를 등록해야 한다.
        //    => application-context.xml 파일에 객체 추가
        // 2) 트랜잭션 관리자가 동작하려면 DAO를 사용하는 객체도 
        //    트랜잭션 관리자와 같은 컨테이너에 있어야 한다.
        //   즉 DAO의 메서드를 사용하는 객체 또한 Spring IoC 컨테이너에 있어야 한다.
        //   => DAO 메서드를 호출하는 Service 객체를 만든다.
        //   => BoardService 클래스 추가
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);

        List<Board> list = boardDao.selectList();

        for(Board board :list) {
            System.out.printf("%d,%s,%s\n", 
                    board.getNo(),board.getTitle(), board.getRegisteredDate());
        }
    }
}