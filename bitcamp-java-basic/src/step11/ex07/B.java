package step11.ex07;

public class B extends A{
    // 인스턴스 변수 추가
    int v2;
    
    
    //만약 수퍼 클래스에 기본 생성자가 없으면 컴파일 오류가 발생한다!!!
    B() {
        //해결 방법?
        // => 수퍼 클래스에 있는 다른 생성자를 호출하라 !
        super(100);
        System.out.println("B() 생성자!");
    }
}  
