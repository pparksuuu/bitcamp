package step23.ex02;

import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 대기 중...");
        //1) 네트워크 연결을 기다리는 역할을 수행할 객체 준비
        // => new ServerSocket(포트번호)
        ServerSocket ss = new ServerSocket(8888);
        // 포트번호
        // => 한 컴퓨터에서 네트워크 연결을 기다리는 프로그램의 식별번호이다.
        
        //2) 대기중인 클라이언트에 연결을 허락한다.
        System.out.println("클라이언트 연결을 기다리는 중...");
        Socket socket = ss.accept();
        
        System.out.println("대기 중인 클라이언트 중 한 개의 클라이언트에 대해 연결 승인!");
        
        
        
        //자원해제
        socket.close();
        System.out.println("클라이언트와의 연결 해제!");
        
        ss.close(); 
        System.out.println("서버 종료!");
    }
}
