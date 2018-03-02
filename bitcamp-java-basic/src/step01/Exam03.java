// 주석
//
/*
  여러 줄 주석
*/

/**
 변수 선언 앞에 설명 붙여 좋으면 HTML 문서 만들 때 추출 할 수 있다.
 */

/**
 javadoc 주석 
 => 소스 파일에서 추출하여 HTML 문서를 만들 때 사용.
 =>클래스, 메서드, 변수 선언 앞에 붙인다.
 */

package step01;

public class Exam03 {
    public static void main(String[] args) {
        System.out.println("src/step01/Exam03");
    }

    // annotation -> @이름
    // compiler나 JVM에게 특별한 명령을 전달할 때 사용하는 아주 특별한 주석
    @Override
    public String toString() {
        return "Exam03";
    }
}

