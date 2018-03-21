// String - mutable vs immutable 객체
package step10;

public class Exam01_3 {
    public static void main(String[] args) {
        //String 객체는 immutable 객체이다.
        //즉 한 번 객체에 값을 담으면 변경할 수 없다.
        
        String s1 = new String("Hello");
        
        //String 클래서에서 제공하는 어떤 메소드를 호출하든지간에
        //원래의 데이터를 변경하지 않느다.
        //다만 새로 String 객체를 만들 뿐.
        String s2 = s1.replace('l', 'x');
        System.out.printf("%s : %s\n", s1, s2);
        
        String s3 = s1.concat(", world!");
        System.out.printf("%s : %s\n", s1, s3); //원본은 바뀌지 않는다.
        
        //StringBuffer는 mutable 객체.
        // 원래의 문자열을 변경하고 싶을 때 사용하는 클래스이다.
        StringBuffer buf = new StringBuffer("Hello");
        buf.replace(2,4, "xx");
        System.out.println(buf);
        
        //StringBuffer를 사용할 때 주의사항
        //StringBuffer의 내용물을 비교할 떄 equals()를 사용해봐야 소용 ㅓㅄ다.
        // == 연산자와 같은 결과를 출력한다!
        StringBuffer b1 = new StringBuffer("Hello");
        StringBuffer b2 = new StringBuffer("Hello");
        if (b1.toString().equals(b2.toString()))
            System.out.println("b1.toString() == b2.toString()");
        else
            System.out.println("b1.toString() != b2.toString()");
        
        //해결책
        // => StringBuffer에서 String을 꺼내 비교하라 
        
    }
}
