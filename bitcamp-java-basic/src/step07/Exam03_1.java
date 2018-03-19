//사용자 정의 데이터 타입 - 인스턴스 메서드
package step07;


public class Exam03_1 {
    public static void main(String[] args) {
        //사용자 정의 데이터 타입 의 값을 연산자를 사용하여 다뤄보자!
        Score2 score = new Score2();
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 85;
        
        //Score 값을 다루는 연산자가 없을 때
        /*
        score.sum = score.kor + score.eng + score.math;
        score.average = score.sum / 3f; 
         */
        Score2.calculate(score); // 연산자(피연산자)
        
        int i = 10;
        ++i;   //연산자(피연산자) 구조!

        System.out.printf("%s, %d, %d, %d, %d, %.1f\n" ,
                score.name, score.kor, score.eng, score.math,
                score.sum, score.average);

    }
}

