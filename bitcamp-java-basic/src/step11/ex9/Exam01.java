//다형성 - 다형적 변수(polymorphic variables)
package step11.ex9;

public class Exam01 {

    public static void main(String[] args) {
        Vehicle a = new Vehicle();
        Bike b = new Bike();
        Car c = new Car();
        Sedan d = new Sedan();
        
        Vehicle a2 = null;
        a2 = b; //OK
        a2 = c; //OK
        a2 = d; //OK
        
        Bike b2 = null;
        b2 = a;
        b2 = c;
        b2 = d;
        
        Car c2 = null;
        c2 = a;
        c2 = b;
        c2 = d;
        
        Sedan d2 = null;
        d2 = a;
        d2 = b;
        d2 = c;
    }

}
