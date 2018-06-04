package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;

@Controller
@RequestMapping("/board")
public class BoardController {

    BoardDao boardDao;

    public BoardController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @RequestMapping("/add")
    public String add(Board board) throws Exception {

            boardDao.insert(board);
            return "redirect:list.do";
            
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {

        int count = boardDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 게시물이 없습니다.");
        }
        return "redirect:list.do";
    }
    
    @RequestMapping("/list")
    public String list(Map<String,Object> map) throws Exception {

        List<Board> list = boardDao.selectList();
        map.put("list", list);
        return "/board/list.jsp";
    }
    
    @RequestMapping("/update")
    public String update(Board board) throws Exception {

        int count = boardDao.update(board);
        if (count == 0) {
            throw new Exception("해당 게시물이 존재하지 않습니다.");
        } 
        return "redirect:list.do";
    }
    
}

//ver 42 - JSP 적용
//ver 40 - 필터 적용
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - BoardAddController 클래스를 서블릿으로 변경
//         출력 결과를 HTML로 변경
//         자동 Refresh 태그 추가
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 
