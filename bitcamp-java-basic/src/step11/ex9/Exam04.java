//다형성 - 다형적 변수 활용
package step11.ex9;

public class Exam04 {

    // Sedan과 Truck의 모델명과 cc를 출력하라.
    // 다형적 변수가 없다면?
    // Sedan, Truck의 모델명과 cc를 출력하는 메소드를 각 각 만들어야 한다.
    public static void printSedan(Sedan sedan) {
        System.out.printf("모델명: %s\n", sedan.model);
        System.out.printf("cc: %d\n", sedan.cc);
        System.out.println("-----------------");
    }
    
    public static void printTruck(Truck truck) {
        System.out.printf("모델명: %s\n", truck.model);
        System.out.printf("cc: %d\n", truck.cc);
        System.out.println("-----------------");
    }

    //다형적 변수 사용 -> 메서드 한 개로 통함
    //두 클래스의 상위 클래스의 레퍼런스를 선언
    public static void printCar(Car car) {
        System.out.printf("모델명: %s\n", car.model);
        System.out.printf("cc: %d\n", car.cc);
        System.out.println("-----------------");
    }
    
    
    
    public static void main(String[] args) {
        Sedan car1 = new Sedan();
        car1.model = "티코";
        car1.cc = 800;
        
        Truck car2 = new Truck();
        car2.model = "타이탄II";
        car2.cc = 10000;
        
        printSedan(car1);
        
        //printSedan()의 파라미터는 Sedan객체의 주소만 받을 수 있다.
        //그래서 Truck 객체를 전달할 수 없다.
        //printSedan(car2); //컴파일 오류
        printTruck(car2);
        //해결책?
        //Truck을 출력하는 메소드를 따로 만들어 사용하라.
        
        printCar(car1);
        printCar(car2);
    }

}
