// 인터페이스의 모든 메서드는 public이기 때문에
// public보다 적게 공개할 수 없다.
package step14.ex02;

public class Exam02 implements A3 {
    // public 보다 좁게 공개 범위를 줄일 수 업삳.
    // private void m1() {}
    // protected void m1() {}
    // void m1() {} //컴파일 오류!
    // 반드시 public이어야 한다.
    public void m1() {}
    public void m2() {}
    
    public static void main(String[] args) {
        
    }
}
