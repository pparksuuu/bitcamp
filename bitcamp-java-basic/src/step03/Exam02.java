// 클래스 - 사용 후
package step03;

public class Exam02 {
    public static void main(String[] args) {
        //여러 변수(메모리)를 묶어서 한 사람의 성적 정보를 저장!
        //낱개 ->식탁에 밥, 국, 반찬들을 쟁반에 담아서 가져오는 상황

        //다양한 타입의 메모리를 묶어서 
        //Score라는 새로운 형태의 메모리를 만들 수 있는 설계도.
        //=> 개발자가 새롭게 정의한 데이터 타입.
        //=> "사용자 정의 데이터 타입"이라 부른다.
        //=> 다음과 같이 클래스 문법을 사용하여 설계도를 정의.
        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }

        //배열 int[] i = new int[5];

        //개발자가 새로 정의한 메모리 설계도에 따라 메모리를 준비.
        //=> Score 설계도에 따라 메모리를 확보하라.
        //=> 확보된 메모리를 사용하려면 주소를 보관할 필요가 있다
        //=> 주소를 보관하려면 reference가 필요하다.
        Score s; //reference
        s = new Score(); 

        //값을 집어 넣기
        //=> 주소를 이용하여 메모리에 접근
        s.name = "홍길동"; //s에 저장된 주소로 찾아가서 name 항목에 값 저장.
        s.kor = 100;
        s.eng = 90;
        s.math = 80;
        s.sum = s.kor + s.eng + s.math;
        s.aver = s.sum / 3;

        //"s가 가리키는 메모리의 name 항목의 값"
        //="s가 가리키는 인스턴스의 name 값" = "s 인스턴스의 name 값(실무)"
        //="s 객체의 값"
        System.out.printf("이름: %s\n", s.name);
        System.out.printf("국어: %d\n", s.kor);
        System.out.printf("영어: %d\n", s.eng);
        System.out.printf("수학: %d\n", s.math);
        System.out.printf("합계: %d\n", s.sum);
        System.out.printf("평균: %.1f\n", s.aver);
        
    }
}

/**
 * 클래스(class)
 * - 여러 타입을 묶어서 사용자 저으이 데이터 타입을 만드는 문법
 * - 관련된 기능(메서드-method, 함수-member function)을 관리하기 편하게 묶는 문법
 * 
 * 배열(array)
 * - 단일한 타입의 메모리를 묶는 문법
 * 
 * primitive 변수와 레퍼런스
 */