// 메소드 정보 추출 - 특정 메서드만 추출
package step18.ex03;

import java.lang.reflect.Method;

public class Exam03 {
    public static void m1() {}
    public void m2() {}
    protected void m3() {}
    void m4() {}
    private void m5() {}
    
    public static void main(String[] args) throws Exception {
        Class clazz = Exam03.class;
        
        // 파라미터가 없는 "m3"이름을 가진 public 메서드 추출
        //Method m = clazz.getMethod("m3"); //못찾는다.
        Method m = clazz.getMethod("m1");
        System.out.println(m.getName());
        System.out.println(clazz.getMethod("toString").getName());
        
        System.out.println("----------------------------"
                );
        // 지정된 클래스에 정의된 메서드를 찾는다. 상속 받은 메서드는 제외한다.
        // public이 아니어도 된다
        m = clazz.getDeclaredMethod("m3");
        System.out.println(clazz.getDeclaredMethod("toString").getName());

        System.out.println(m.getName());
    }
}
