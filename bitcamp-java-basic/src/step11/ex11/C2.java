package step11.ex11;

public class C2 extends C {
    // 다음은 C의 메서드를 오버라이딩 한 게 아니다!
    // 왜? C의 m1은 private이기 때문에 오직 C에서만 사용할 수 있다.
    //그럼 다음 m1()은? 그냥 C2에 새로 추가한 메서드이다.
    /*
    @Override
    private void m1() {}
    */
    
    //다음은 전형적인 오버라이딩의 예이다.
    /*
    @Override protected void m2() {}
    @Override void m3() {}  //default modifier. 접근 범위를 조정하는 명령어.
    @Override public void m4() {}
    */
    
    //@Override void m2() {} //컴파일 오류!
    @Override public void m2() {}
}


//멤버의 접근 범위
// private   : 같은 클래스
// (defalut) : 같은 클래스 + 같은 패키지
// protected : 같은 클래스 + 같은 패키지 + 서브 클래스
// public    : 모두 

// 수퍼 클래스의 메서드를 자식클래스가 재정의할 때
// 접근 범위를 확대할 순 있지만, 좁힐 수는 없다!
