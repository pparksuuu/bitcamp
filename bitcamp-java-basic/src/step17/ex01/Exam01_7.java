// 클래스의 종류 : 중첩 클래스 요약 정리
package step17.ex01;

import java.io.File;
import java.io.FilenameFilter;

//패키지 멤버 클래스  -public이냐 아니냐.
class A{}

// 패키지 멤버 클래스 
public class Exam01_7 {
    
    //클래스 안의 클래스
    // static nested class
    static class B {}
    
    // non-static nested class = inner class
    class C {}

    public static void main(String[] args) {
        
        // 메소드 안에 있는 것
        // local class
        class D{}
        
        //anonymous class
        Object obj = new Object() {};
    }

}
