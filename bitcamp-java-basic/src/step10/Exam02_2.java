// Wrapper 클래스 - auto-boxing/auto-unboxing
package step10;

public class Exam02_2 {
    public static void main(String[] args) {
        int i1 = 100;
        
        //int ==> Integer
        Integer obj1 = new Integer(i);
        
        //Integer ==> int
        Integer obj2 = new Integer(200);
        int i2 = obj2.intValue();
        
        //JDK 1.5부터 auto-boxing, auto-unboxing 제공
        //auto - boxing
        // int값을 가지고 자동으로 Integer 랩퍼 겍체를 만든다.
        Integer obj3 = i1; //내부적으로 new Iteger(i1)으로 바뀐다.
                           //int 값이 obj3에 저장되는 것이 아니라
                           //내부적으로 Integer 객체가 생성되어 그 주소가 저장된다.
        
        //auto - unboxing
        //Integer 객레에서 값을 꺼내 리턴한다.
        //이렇게 객체 안에 들어있는 값을 자동으로 꺼낸다고 해서 "오토 언박싱.이라 부른다ㅣ
       Integer obj4 = new Integer(300);
       int i3 = obj4;                  
    }
}
