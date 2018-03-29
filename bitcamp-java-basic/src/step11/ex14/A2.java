package step11.ex14;

public class A2 extends A {
    @Override //오버라이드할 때 항상 이걸 붙이는 습관을 들여라. 내가 제대로 오버라이딩했는지 검사받기 위해
    public void m() { 
        System.out.println("A2의 m() 호출!");
    }
    
    public void x() {
        System.out.println("A2에서 추가한 메서드 X.");
    }
}
