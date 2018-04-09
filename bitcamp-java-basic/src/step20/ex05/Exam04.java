// 애노테이션 프로퍼티 값 추출
package step20.ex05;

public class Exam04 {
    public static void main(String[] args) {
        // 클래스 정보 객체로부터 애노테이션 정보 추출
        Class clazz = MyClass4.class;
        
        // => 유지정책 : CLASS
        MyAnnotation3 obj = (MyAnnotation3) clazz.getAnnotation(MyAnnotation3.class);
        
        System.out.println(obj.v1()[0]);
        System.out.println(obj.v2()[0]);
        System.out.println(obj.v3()[0]);
    }
}
