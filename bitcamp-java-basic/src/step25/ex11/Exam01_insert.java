// mybatis + springIoC = 트랜잭션 정책 test
package step25.ex11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step25/ex11/application-context.xml");
        
        BoardService boardService = iocContainer.getBean(BoardService.class);
        
        Board b1 = new Board().setNo(211).setTitle("1111").setContent("xxxx");
        Board b2 = new Board().setNo(212).setTitle("2222").setContent("xxxx");
        Board b3 = new Board().setNo(213).setTitle("3333").setContent("xxxx");
        Board b4 = new Board().setNo(211).setTitle("4444").setContent("xxxx");
        Board b5 = new Board().setNo(215).setTitle("5555").setContent("xxxx");
        
        
        boardService.test1(b1, b2, b3, b4, b5);
    }
}

// 
