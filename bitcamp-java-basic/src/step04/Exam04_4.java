// 비트 이동 연산자 : 응용
package step04;

public class Exam04_4 {
    public static void main(String[] args) {
        int i = 0x27_a1_30_ff;
        int a, b, c, d;
        int j = 0x27_a1_30_ff;
        
        System.out.println(Integer.toHexString(i));
        
        //i 변수에 들어있는 값을 1바이트씩 잘라서 16진수로 출력하라!

        System.out.println("====================================");

        //1) 27
        //27_a1_30_ff = 00100111_10100001_00110000_11111111
        a = i >> 24; // 00000000_00000000_00000000_00100111
        
        //2) a1
        b = (i >> 16) & 0xff; 
        
        //3) 30
        c = (i >> 8) & 0xff;
        
        //4) ff
        d = i & 0xff;

        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toHexString(b));
        System.out.println(Integer.toHexString(c));
        System.out.println(Integer.toHexString(d));

        
    }
}

