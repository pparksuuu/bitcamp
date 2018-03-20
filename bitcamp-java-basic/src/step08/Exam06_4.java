// 초기화 블록 - 클래스 블록 = static 블록
package step08;

public class Exam06_4 {
    public static class A {
        static int a;
        static void m() {}

        //스태틱 블록은 클래스가 로딩된 후에 자동으로 순서대로 실행된다.
        static {
            System.out.println("Static{}1111");
        }
        
        static {
            System.out.println("Static{}2222");
        }
       
    }
    public static void main(String[] args) throws Exception { 
        //클래스가 로딩되는 경우
        // => 레퍼런스를 선언할 때는 로딩되지 않는다.
        A obj1;
        A obj2;
        
        // 1) 클래스 멤버(변수와 메서드)를 최초로 사용할 때(한 번만 !!!)
        //A.a = 100;
        System.out.println("------------");
        
        //A.m();
        System.out.println("************");
     
        // 2) 해당 클래스의 인스턴스를 최초로 생성할 때.
        new A();
        System.out.println("============");

        // 3) 자바에서 제공하는 도구를 사용하여 강제로 클래스를 로딩시키는 경우
        Class.forName("step08.Exam06_4$A");
    }
}
