package step14.ex02;

public class Exam01 {
    public static void main(String[] args) {
        //A4 obj = new A4(); //컴파일 오류
        
        // 인터페이스의 모든 변수는 스태틱 변수이다.
        System.out.println(A4.v1);
        
        //A4.v2 = 300; //Compile Error !
    }
}
