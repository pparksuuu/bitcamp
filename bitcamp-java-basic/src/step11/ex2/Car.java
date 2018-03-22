package step11.ex2;

public class Car {
    String model;
    String maker;
    int capacity;
    boolean sunroof;
    boolean auto;
    
    public Car() {};
    
    //이전 프로그램(ex1.Exam01)에서 다음 생성자를 사용하기 때문에
    //이 생성자에 파라미터를 덧붙일 수는 없다.
    public Car(String model, String maker, int capacity) {
        this.model = model;
        this.maker = maker;
        this.capacity = capacity;
    }
    
    public Car(String model, String maker, int capacity,
            boolean sunroof, boolean auto) {
        this.model = model;
        this.maker = maker;
        this.capacity = capacity;
        this.sunroof = sunroof;
        this.auto = auto;
    }
    
}
