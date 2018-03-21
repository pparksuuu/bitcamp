//클래스 변수의 응용
package step08;

public class Exam01_6 {

    static class Member {
        //모든 인스턴스가 다음의 변수에 대해 같은 값을 가질 경우,
        //클래스 변수로 만드는 것이 바람직
        // => 조회 용도라면 대문자로 선언하여 상수임을 표현
        // => 조회 용도라면 문법적으로 값을 변경하는 것을 막아라!
        // => 조회 용도 변수는 공개해도 되기 때문에 public으로 선언!
        public final static int GUEST = 0;
        public final static int MEMBER = 1;
        public final static int MANAGER = 2;
        
        String id;
        String password;
        int type; // 0: 손님, 1: 회원, 2: 관리자  
    }
    public static void main(String[] args) {
        Member m1 = new Member();
        m1.id = "aaa";
        m1.password = "1111";
        m1.type = 0;
        
        Member m2 = new Member();
        m2.id = "bbb";
        m2.password = "1111";
        m2.type = 2;
        
        Member m3 = new Member();
        m3.id = "ccc";
        m3.password = "1111";
        m3.type = 1;
        
        //회원의 타입을 지정할 떄 숫자를 이용하였다.
        //그런데 숫자는
        Member m4 = new Member();
        m4.id = "aaa";
        m4.password = "1111";
        m4.type = Member.GUEST;
        
        Member m5 = new Member();
        m5.id = "aaa";
        m5.password = "1111";
        m5.type = Member.MANAGER;
        
        
        Member m6 = new Member();
        m6.id = "aaa";
        m6.password = "1111";
        m6.type = Member.MEMBER;
        
        Member.MANAGER
        
    }

}

//
