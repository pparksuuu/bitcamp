package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

import java.util.Scanner;

public class BoardController {

    public static Scanner keyScan;

    static Board[] boards = new Board[1000];
    static int boardIndex = 0;

    public static void service(String menu, String option) {
        if (menu.equals("board/add")) {
            onBoardAdd();
        } else if (menu.equals("board/list")) {
            onBoardList();
        } else if (menu.equals("board/view")) {
            onBoardView(option);
        } else if (menu.equals("board/update")) {
            onBoardUpdate(option);
        } else if (menu.equals("board/delete")) {
            onBoardDelete(option);
        } else {
            System.out.println("You're in the board");
            System.out.println("명령어가 올바르지 않습니다");
        }
    }

    static int getBoardIndex(String number) {
        int num = Integer.parseInt(number);
        for (int i = 0; i < boardIndex; i++) {
            if (boards[i] == null) continue;
            if (boards[i].number == num) {
                return i;
            }
        }
        return -1;
    }

    static void onBoardAdd() {
        System.out.println("[게시글 등록]");
        Board board = new Board();

        System.out.print("제목? ");
        board.title = keyScan.nextLine();
        System.out.print("내용? ");
        board.content = keyScan.nextLine();
        System.out.print("등록일? ");
        board.date = keyScan.nextLine();
        board.number = boardIndex;
        boards[boardIndex++] = board;
    }

    static void onBoardList() {
        System.out.println("[게시글 목록]");
        for (int i = 0; i < boardIndex; i++) {
            if (boards[i] == null) continue;
            System.out.printf("%d, %s, %s\n", boards[i].number, 
            boards[i].title, boards[i].date);
        }   
    }
    
    static void onBoardView(String number) {
        System.out.println("[게시글 조회]");
        if (number == null) {
            System.out.println("게시글 번호를 입력하시기 바랍니다.");
            return;
        }

        int i = getBoardIndex(number);
        
        if (i == -1) {
            System.out.println("해당 번호의 게시글이 없습니다.");
        } else {
            Board board = boards[i];
            System.out.printf("제목: %s\n",board.title);
            System.out.printf("내용: %s\n",board.content);
            System.out.printf("등록일: %s\n",board.date);
        }
    }
    
    static void onBoardUpdate(String number) {
        System.out.println("[게시글 변경]");
        if (number == null) {
            System.out.println("게시글 번호를 입력하시기 바랍니다.");
            return;
        }

        int i = getBoardIndex(number);
        
        if (i == -1) {
            System.out.println("해당 번호의 게시글이 없습니다.");
        } else {
            Board board = boards[i];
            Board boardUpdate = new Board();
            System.out.printf("제목(%s): ", board.title);
            boardUpdate.title = keyScan.nextLine();            
            System.out.printf("내용(%s): ", board.content);
            boardUpdate.content = keyScan.nextLine();  
            boardUpdate.date = board.date;  
            boardUpdate.number = board.number;
            
            boards[i] = boardUpdate;        
        }
    }

    static void onBoardDelete(String number) {
        System.out.println("[게시글 삭제]");
        if (number == null) {
            System.out.println("게시글 번호를 입력하시기 바랍니다.");
            return;
        }

        int i = getBoardIndex(number);
        
        if (i == -1) {
            System.out.println("해당 번호의 게시글이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                boards[i] = null;
                System.out.print("삭제하였습니다.");
            }
        }
    }

}