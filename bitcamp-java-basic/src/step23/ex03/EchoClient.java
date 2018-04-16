// 응용 - 에코 서버 만들기
package step23.ex03;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());

        out.println(args[0]);
        
        // 서버가 보낸 데이터를 ㅇ릭고 화면에 출력한다.
        String str = in.nextLine();
        System.out.println(str);
        
        in.close();
        out.close();
        socket.close();
    }
}
