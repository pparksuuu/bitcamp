// 비트 이동 연산자 : >>, >>>, << 
package step04;

public class Exam04_1 {
    public static void main(String[] args) {
        int i = 1; //~ 0000 0001
        System.out.println(i << 1); //~ 0000 0010
        System.out.println(i << 2); //~ 0000 0100
        System.out.println(i << 3); //~ 0000 1000
        System.out.println(i << 4); //~ 0001 0000

        i = 0b0000_1011; //11
        System.out.println(i << 1); //22 => 00010110
        System.out.println(i << 2); //44 => 00101100
        System.out.println(i << 3); //88 => 01011000
        
        
    }
}
