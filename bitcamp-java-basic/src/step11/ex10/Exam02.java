//메서드 오버로딩 응용
package step11.ex10;

public class Exam02 {
    public static void main(String[] args) {
        // 같은 이름의 메서드가 여러 개 있을 경우,
        // 아규먼트의 타입과 개수, 순서에 따라 호출될 메서드가 자동을 결정된다. 
        System.out.println(Calculator.plus(100, 200));
        System.out.println(Calculator.plus(100.5f, 200.2f));
        System.out.println(Calculator.plus("33", "77"));
    }
    

}
