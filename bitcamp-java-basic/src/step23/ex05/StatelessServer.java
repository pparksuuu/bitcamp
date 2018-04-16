package step23.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class StatelessServer {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중");
        // 합계를 계산하는 서버를 만들어보자!
        ServerSocket ss = new ServerSocket(8888);

        while (true) {
            Socket socket = ss.accept();
            System.out.println("클라이언트 연결 승인 및 작업 처리 중");
            processRequest(socket);
        }
    }

    static void processRequest(Socket socket) throws Exception {
        try (
                Socket socket2 = socket;
                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner in = new Scanner(socket.getInputStream());
            ) {

            // 클라이언트와 연결되면 클라이언트는 값을 한 개 보낸다.
            int sum = 0;

            String str = in.nextLine();
            if (str.equals(""))
                out.println("결과는 = " + sum);
            
            sum += Integer.parseInt(str);

        }
    }
}
