// 클라이언트 + 키보드 입력 + 무한 반복
package step23.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender3 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);

        Socket socket = new Socket("192.168.0.40", 8888);
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());

        while (true) {

            System.out.print("입력> ");
            String input = keyScan.nextLine();
            out.println(input);

            String str = in.nextLine();
            System.out.println(str);
            
            if (input.equals("quit"))
                break;
        }

        in.close();
        out.close();
        socket.close();
        keyScan.close();
    }
}
