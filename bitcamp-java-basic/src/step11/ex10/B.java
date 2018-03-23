package step11.ex10;

public class B extends A{
    //부모 A에 이미 plus()라는 이름을 가진 메서드가 여러 개 있따.
    //그럼에도 불구하고 파라미터 형식이 다른 메서드를 추가한다면
    //마찬가지로 "오버로딩"이다.
    static void m(int a, int b, int c) {
        System.out.println("m(int,int,int)");
    }
}
