//메서드 : 인스턴스와 Heap 메모리 영역
package step06;

class MyObject {
    int a;
    int b;
}

public class Exam04_3 {

    static MyObject getMyObject() {
        //Exam03_3.java에 정의된 MyObject 클래스 사용.
        MyObject ref = new MyObject();
        ref.a = 100;
        ref.b = 200;
        return ref;   
    }
 
    public static void main(String[] args) {
        MyObject ref;
        ref = getMyObject();
        System.out.println(ref.a);
        System.out.println(ref.b);
    }
}
