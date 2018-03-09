// 비트 이동 연산자 : >>, >>>, << 
package step04;

public class Exam04_3 {
    public static void main(String[] args) {
        int i = 0b01101001; //105
        System.out.println(i);
        System.out.println(i >>> 1); //00110100|1 => 52
        System.out.println(i >>> 2); //00011010|0 => 26
        System.out.println(i >>> 3); //00001101|0 => 13
        System.out.println(i >>> 4); //00000110|1 => 6
        
        /**
         * 오른쪽으로 이동 후,
         * 왼쪽 쪽 빈자리 : 원래 숫자와 같은 부호 값으로 채운다.
         *                 양수면 0, 음수면 1
         * 오른쪽 경계를 넘어간 비트 : 짜른다.
         */
        
         //음수를 이동
         i = 0b11111111_11111111_11111111_10101001; //-87
         System.out.println(i);
         System.out.println(i >>> 1); 
         //0_11111111_11111111_11111111_1010100|1 => -44
         //=>왼쪽 빈자리 0으로 채운다.
         //  양수로 바뀌는 순간 엄청나게 큰 수가 된다.

         System.out.println(i >>> 2); 
         //00_11111111_11111111_11111111_101010|01 => -22

         System.out.println(i >>> 3); 
         //000_11111111_11111111_11111111_10101|001 => -11

         System.out.println(i >>> 4); 
         //0000_11111111_11111111_11111111_1010|1001 => -6
         
    }
}

