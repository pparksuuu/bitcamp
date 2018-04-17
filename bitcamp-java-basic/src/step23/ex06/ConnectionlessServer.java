// connectionlessServer - 연결 없이 데이터 수신
package step23.ex06;

import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

//연결지향(conn
public class ConnectionlessServer {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        
        // 특정 포트로 들어온 데이터를 받을 서버 소켓
        DatagramSocket socket = new DatagramSocket(8888);
        
        // 받은 데이터를 저장할 버퍼 준비.
        byte[] buf = new byte[8196];
        
        // 빈 패킷
        DatagramPacket emptyPacket = new DatagramPacket(buf, buf.length);
       
        // 빈 패킷을 사용하여 들어온 데이터를 받는다.
        socket.receive(emptyPacket);
        
        socket.close();
        
        // 빈 패킷에 저장된 수신 데이터를 꺼낸다.
        // 패킷에 저장된 UTF-8로 인코딩된 바이트 배열을 가지고 String 객체를 만든다. 
        String message = new String(
                emptyPacket.getData(), 0, emptyPacket.getLength(), "UTF-8");
        System.out.println(message);
    }
}
