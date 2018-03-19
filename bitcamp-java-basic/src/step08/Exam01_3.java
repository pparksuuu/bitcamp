//클래스 변수와 인스턴스 변수 생성 시점과 메모리 영역
package step08;

public class Exam01_3 {

    static class A {
        static int v1;
        int v2;
    }
    public static void main(String[] args) {
        A.v1 = 100;
        
        //A.v2 = 200; //에러
        A p = new A(); //이제 v2 변수는 Heap에 생성되었다.
        
        //v2 인스턴스 변수는 인스턴스 주소를 통해 사용해야 한다.
        //A.v2 = 200; //컴파일 오류
        
        p.v2 = 200;
        p.v1 = 100;
        
        //인스턴스 변수는 인스턴스를 만들 때 마다 생성된다.
        A p2 = new A(); //새 v2 변수가 생성된다.
        p2.v2 = 300;
        
        
        System.out.printf("A.v1 = %d, p.v2 = %d, p2.v2 = %d \n",
                A.v1, p.v2, p2.v2);
    }

}

//
