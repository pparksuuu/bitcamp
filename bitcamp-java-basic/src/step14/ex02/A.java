// 인터페이스 정의
package step14.ex02;

public interface A {
    public void m1();
    void m2(); //public 생략. default 아님.
    private void m3();
    protected void m4();
    void m5();
}
