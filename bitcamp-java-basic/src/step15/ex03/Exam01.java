package step15.ex03;

public class Exam01 {
    public static void main(String[] args) {
        Restaurant obj1 = new Restaurant();
        Farm obj2 = new Farm();
        
        // 레스토랑이나 농장의 기본 흐름은 이미 정해져 있다.
        obj1.build();
        System.out.println("================================");
        obj2.build();
    }

}
