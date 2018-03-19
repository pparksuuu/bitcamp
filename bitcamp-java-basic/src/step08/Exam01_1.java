//인스턴스 변수
package step08;

public class Exam01_1 {

    public static void main(String[] args) {
        class A {
            //인스턴스 변수
            // => new 명령을 통해 생성된다.
            // => new 명령을 실행하기 전까지는 인스턴스 변수는 존재하지 않는다.
            // => Heap 영역에 생성된다.
            // => static이 붙지 않는다.
             int v1;
             boolean v2;
             //이 명령은 new 명령을 실행할 때 비로서 실행된다.
        }
        
        A obj1 = new A(); 
        A obj2 = new A();
        A obj3 = new A();
        //이렇게 생성된 메모리를 "인스턴스", "객체"라고 부른다.
        // obj1, obj2, obj3 -> "레퍼런스"
        // v1, v2 -> "인스턴스"
        
        obj1.v1 = 100;
        obj2.v1 = 200;
        obj3.v1 = 300;
        System.out.printf("%d, %d, %d\n", obj1.v1, obj2.v1, obj3.v1);
    }

}

//
