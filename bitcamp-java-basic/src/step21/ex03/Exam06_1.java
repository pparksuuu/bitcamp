// 예외 처리 후 마무리 작업 - finally 블록과 자원해제
package step21.ex03;

import java.util.Scanner;

public class Exam06_1 {

    static void m() {
        // 키보드 입력을 받기 위한
        Scanner keyScan = new Scanner(System.in);
        
        // 스캐너 객체를 사용하여 키보드 입력을 읽어들인다.
        // => 예외가 발생한다면
        System.out.print("입력> ");
        int value = keyScan.nextInt();
        System.out.println(value * value);
        
        // 프로그램을 즉시 종료하는 경우라면,
        // 스캐너를 다 사용하고 난 다음에 굳이 스캐너에 연결된 키보드와 연결을 끊을 필요는 없다.
        // 그러나 365일 24시간 내내 실행되는 시스템이라면, 
        // 키보드를 사용하지 않는 동안에는 다른 프로그램에서 사용할 수 있도록 
        // 스캐너와 연결된 키보드를 풀어줘야 한다.
        // 이것을 "자원해제"라고 부른다.
        // 보통 자원해제시키는 메서드의 이름이 "close()"이다.
        //
        
        keyScan.close();
        
        // close()를 호출하기 전에 예외가 발생한다면,
        // 제대로 자원 해제 x.
        // 해결방법 -> finally 블록 사용. (정상적 실행이든 예외 발생이든 무조건 받는다)ㄴ
    }
    public static void main(String[] args) {
        m();
    }
}
