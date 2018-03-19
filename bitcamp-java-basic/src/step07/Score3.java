
// 사용자 정의 데이터 타입 - 메서드 => 연산자

package step07;

public class Score3 {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float average;
        //메서드를 이용하여 이 타입의 데이터를 다룰 수 있는 연산자를 정의한다.
        
        //Score 데이터 값을 다룰 수 있는 새 연산자를 정의.
        public static void calculate(Score3 score) {
            score.sum = score.kor + score.eng + score.math;
            score.average = score.sum / 3f;
        }
}
