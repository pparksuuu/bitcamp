// 클래스 - 사용 전
package step03;

public class Exam02_1 {
    public static void main(String[] args) {
        //여러 개의 인스턴스 주소 저장하기

        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }


        // Score 레퍼런스 준비
        Score s1, s2, s3;
        
        s1 = new Score();
        s2 = new Score();
        s3 = new Score();

        s1.name = "홍길동";
        s2.name = "임꺽정";
        s3.name = "유관순";

        System.out.printf("이름: %s\n", s1.name);
        System.out.printf("이름: %s\n", s2.name);
        System.out.printf("이름: %s\n", s3.name);
        
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