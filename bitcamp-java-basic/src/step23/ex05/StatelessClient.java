package step23.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Stateless 방식의 특징
// => 클라이언트와 계속 연결을 유지하기 때문에 작업 결과를 계속 서버에 유지할 수 있다.
// 
public class StatelessClient {
    public static void main(String[] args) throws Exception {
        try(Scanner keyScan = new Scanner(System.in);){

            while (true) {
                System.out.print("값? ");
                String str = keyScan.nextLine(); // 키보드에서 값을 입력 받아

                try(
                        Socket socket = new Socket("localhost", 8888);
                        PrintStream out = new PrintStream(socket.getOutputStream());
                        Scanner in = new Scanner(socket.getInputStream())) { 

                    out.println(str); // 서버에 보낸다
                    if (str.equals("")) { // 만약 값을 입력하지 않았으면
                        System.out.println(in.nextLine()); // 서버가 보낸 결과를 출력한다.
                        break;
                    }
                }
            }
        }
    }

    static void processRequest(Socket socket) throws Exception {
        try (
                Socket socket2 = socket;
                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner in = new Scanner(socket.getInputStream());
                ) {

            int sum = 0;

            while (true) {
                String str = in.nextLine();
                if (str.equals(""))
                    break;
                sum += Integer.parseInt(str);
            }

            out.println("결과는 = " + sum);
        }
    }
}
