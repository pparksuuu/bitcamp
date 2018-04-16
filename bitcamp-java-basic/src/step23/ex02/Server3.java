// 대기열 - 대기열 크기 조정
package step23.ex02;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.println("서버 실행!");
        
        keyScan.nextLine();
        // new ServerSocket(포트번호, 대기열개수);
        // => 대기열 개수를 초과하여 클라이언트가 연결을 요청하면 연결을 거절한다.
        ServerSocket ss = new ServerSocket(8888, 2);
        System.out.println("클라이언트 연결을 기다리는 중...");
        
        keyScan.nextLine();
        Socket socket = ss.accept();
        System.out.println("대기 중인 클라이언트 중 한 개의 클라이언트에 대해 연결 승인!");
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("입출력 스트림 준비");
        
        keyScan.nextLine();
        
        
        System.out.println("클라이언트 데이터 수신 중...");
        System.out.println(in.nextLine());
        System.out.println("클라이언트 데이터 수신 완료!");
        
        System.out.println("클라이언트에게 응답 보냄!");
        out.println("OK!");
        
        socket.close();
        System.out.println("클라이언트와의 연결 해제!");
        
        ss.close(); 
        System.out.println("서버 종료!");
    }
}
