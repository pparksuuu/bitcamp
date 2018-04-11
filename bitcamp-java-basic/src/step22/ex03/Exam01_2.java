// 데이터 출력 - int 값 출력
package step22.ex03;

import java.io.FileOutputStream;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");

        int money = 1_3456_7890; // 0x080557D2

        out.write(money >> 24); // 00000008|0557d2
        out.write(money >> 16); // 00000805|57d2 
        out.write(money >> 8);  // 00080557|d2 
        out.write(money);       // 080557d2|
        
        out.close();

        System.out.println("데이터 출력 완료!");
    }
}
