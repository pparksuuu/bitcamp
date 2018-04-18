package bitcamp.java106.pms.controller.board;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/board/update")
public class BoardUpdateController implements Controller {
    BoardDao boardDao;
    
    public BoardUpdateController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        Board updateBoard
        
        Board board = boardDao.get(Integer.parseInt(option));
        
        if (board == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            Board updateBoard = new Board();
            updateBoard.setNo(board.getNo());
            System.out.printf("제목(%s)? ", board.getTitle());
            updateBoard.setTitle(this.keyScan.nextLine());
            System.out.printf("설명(%s)? ", board.getContent());
            updateBoard.setContent(this.keyScan.nextLine());
            updateBoard.setCreatedDate(board.getCreatedDate());
            
            int index = boardDao.indexOf(board.getNo());
            boardDao.update(index, updateBoard);
            System.out.println("변경하였습니다.");
        }
    }
}

//ver 26 - BoardController에서 update() 메서드를 추출하여 클래스로 정의.
