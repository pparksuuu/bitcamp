// JDBC 프로그래밍 개요 - DBMS에 SQL문 보내기 : insert
package step25.ex4;

import java.util.Scanner;

public class Exam01_update {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        Board board = new Board();
        
        System.out.print("변경할 게시물 번호? ");
        board.setNo(Integer.parseInt(keyScan.nextLine()));
        
        System.out.print("제목? ");
        board.setTitle(keyScan.nextLine());
        
        System.out.print("내용? ");
        board.setContent(keyScan.nextLine());
        
        try {
            DataSource dataSource = new DefaultDataSource();
            BoardDao boardDao = new BoardDao(dataSource);
            int count = boardDao.update(board);
            System.out.printf("%d개 변경 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        keyScan.close();
    }
}
