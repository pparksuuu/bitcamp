// 비동기 방식으로 인한 문제 해결책
package step24.ex05;

public class Exam01 {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account("111-11-1111-111", 100_0000);
        
        ATM 강남 = new ATM("강남", account);
        ATM 서초 = new ATM("서초", account);
        ATM 부산 = new ATM("부산", account);
        ATM 대전 = new ATM("대전", account);
        ATM 광주 = new ATM("광주", account);
        
        강남.start();
        서초.start();
        부산.start();
        대전.start();
        광주.start();
        
        
        // 강남, 서초 등 여러 개의 스레드가 같은 객체의 같은 메서드를 동시에 호출할 때
        // 서로 그 메모리의 값을 덮어쓰는 문제가 발생한다.
        
    }

}
