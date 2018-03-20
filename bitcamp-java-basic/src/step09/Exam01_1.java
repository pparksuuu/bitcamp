// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package step09;

public class Exam01_1 {
    public static void main(String[] args) {
        // 생성자를 호출하여 문자열 인스턴스를 초기화시킨다.
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        
        //s1, s2는 다른 인스턴스
        // => 증명
        if (s1 == s2) { //s1의 주소 값과 s2의 주소 값을 비교 !
            System.out.println("s1 == s2");
        }
        else {
            System.out.println("s1 != s2");
        }
        
        //다른 생성자를 사용하여 스트링 인스턴스를 초기화시키기
        char[] chars = new char[] {'H', 'e', 'l', 'l', 'o'};
        String s3 = new String(chars);
        
        System.out.printf("%s %s %s \n", s1, s2, s3);
        
        //바이트 배열을 가지고 스트링 만들기
        byte[] bytes = {(byte)0xb0,(byte)0xa1, (byte)0xb0, (byte)0xa2, 
                (byte)0xb6, (byte)0xca, (byte)0xb6, (byte)0xcb};
        String s4 = new String(bytes);
        System.out.println(s4);
        //출력이 깨지는 이유ㅠ
        //EUC-KR 코드 값이 들어 있는 바이트 배열이 제대로 유니토드 배열로 저장되지 않았기 때문.
        //이 생성자는 바이트 배열에 들어 있는 값이 ISO - 150= 4459=1
        
        //해결책?
        //String 클래스의 생성자 중에서 바이트 배열과 인코딩 정보를 팜께 밥는 생상자를ㄹㄹㄹㄹ///
        String s5 = new String(bytes, "EUC-KR");
        System.out.println();
        
    }
}

// 생성자
// => 인스턴스 변수를 초기화시키기 위해 여러 개의 생성자를 만들어 제공할 수 있다.
// => 자신에게 맞는 적절한 생성자를 호출하여 인스턴스를 초기화시킨 후 사용하면 된다.
