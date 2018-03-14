//메서드 : 스택 메모리 응용 III - 스택오버플로우
package step06;


public class Exam04_6 {

    static int sum(int value) {
        //종료 조건을 빼버리면, 무한으로 호출한다.
        /** 
        if(value == 1)
            return 1;
        */
        long a1, a2, a3, a4, a5, a6, a7, a8, a9;
        System.out.println(value);
        return value + sum(value - 1);
    }
    public static void main(String[] args) {
        //작은 수 -> 재귀호출 사용 OK. 
        //코드도 간단하고 이해하기도 쉽다.
        System.out.println(sum(100));

        //큰 수 -> 재귀호출 수가 높아짐.
        //쉽게 스택 메모리 부족
        System.out.println(sum(100000));
    }
}
