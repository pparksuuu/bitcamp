//메서드 : Heap 메모리 영역
package step06;

import java.util.Scanner;

public class Exam04_2 {

    static int[] getArray() {
        int[] arr = new int[] {100, 200, 300};
        return arr;   
    }
 
    public static void main(String[] args) {
        int[] arr;
        arr = getArray();
        System.out.println(arr[1]); //200;
    }
}

/**
 1) main() 호출
    => JVM Stack: args, arr 변수 생성
 2) getArray() 호출
    => JVM
 */


