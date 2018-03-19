
// 사용자 정의 데이터 타입 - 메서드 => 연산자

package step07;

public class Score2 {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float average;
        //메서드를 이용하여 이 타입의 데이터를 다룰 수 있는 연산자를 정의한다.
        
        //Score 데이터 값을 다룰 수 있는 새 연산자를 정의. => 클래스 메서드
  
        public static void calculate(Score2 score) {
            score.sum = score.kor + score.eng + score.math;
            score.average = score.sum / 3f;
        }
    //클래스 메서드
    //=> static이 붙은 메서드 
    //=> 특정 인스턴스에 대해 사용하는 것이 아니라, 모든 인스턴스에 대해 사용할 수 있다.
    //=> 특정 인스턴스의 값을 다루고 싶다면 파라미터로 그 인스턴스의 주소를 받아야 한다.
}
