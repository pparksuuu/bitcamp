// 클라이언트 + 키보드 입력
package step23.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender2 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        // 1) 다른 컴퓨터와 네트워크로 연결한다.
        Socket socket = new Socket("192.168.0.40", 8888);
        
        // 2) 소켓 객체를 통해 읽고 쓸 수 있도록 입출력 스트림을 얻는다.
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        // 키보드 입력을 받아서 서버에게 전송한다.
        System.out.print("입력> ");
        String input = keyScan.nextLine();
        out.println(input);

        // 서버가 보낸 데이터를 수신한다.
        String str = in.nextLine();
        System.out.println(str);
        
        in.close();
        out.close();
        socket.close();
        keyScan.close();
    }
}
