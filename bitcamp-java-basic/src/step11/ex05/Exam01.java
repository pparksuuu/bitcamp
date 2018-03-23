package step11.ex05;

public class Exam01 {
    public static void main(String[] args) {
        //B 클래스의 설계도에 따라 Heap 영역에 변수를 준비한다
        B obj = new B();
        obj.v2 = 200;
        obj.v1 = 100;
        System.out.printf("v1 = %d, v2 = %d", obj.v1, obj.v2);
    }
}


/*
 * 용어 정리 !
 * 상속(inheritance)
 * => 기존에 만든 클래스를 자신의 코드처럼 사용하는 기법 
 * => 보통 기존 코드를 손대지 않고 새 코드를 덧붙일 때 많이 사용한다.
 * 
 * 수퍼클래스(super class) = 부모클래스(parentㄴ class)
 * => A 클래스처럼 상속해주는 클래스를 말한다.
 * 
 * 서브클래스(sub class) = 자식클래스(child class)
 * => B 클래스처럼 다른 클래스를 상속 받는 클래스를 말한다.
 * */
