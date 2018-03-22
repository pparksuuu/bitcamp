package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Board;

public class BoardDao {
    Board[] boards = new Board[1000];
    int boardIndex = 0;
    
    public void insert(Board board) {
        board.number = boardIndex;
        this.boards[this.boardIndex++] = board;
    }
    
    public Board[] list() {
        Board[] arr = new Board[boardIndex];
        for(int i = 0; i < this.boardIndex; i ++) {
           // if (this.boards[i] == null) continue;
            arr[i] = boards[i];
        }
        return arr;
    }
    
    
    public Board get(int number) {
        for (int i = 0; i < this.boardIndex; i++) {
            if (this.boards[i] == null) continue;
            if (this.boards[i].number == number) {
                return boards[i];
            }
        }
        return null;
    }
    
    public void update(Board board) {
        boards[board.number] = board;
    }
    
    public void delete(Board board) {
        boards[board.number] = null;
    }
    
}
