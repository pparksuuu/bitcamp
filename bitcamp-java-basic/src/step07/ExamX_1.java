//클래스 용도  - 소스 코드를 관리하기 쉽게 관련된 기능을 묶을 때 사용. 
package step07;

public class ExamX_1 {
    public static void main(String[] args) {
        //사용자 정의 데이터 타입 
        //=> new 명령 사용하여 메모리 준비
        //=> 생성된 메모리는 Heap 영역에 생성
        //=> 메모리 주소를 레퍼런스에 저장
        Score score = new Score();

        // 클래스로 만든 메모리는 레퍼런스를 통해 접근
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 85;
        score.sum = score.kor + score.eng + score.math;
        score.average = score.sum / 3f; 

        System.out.printf("%s, %d, %d, %d, %d, %.1f\n" ,
                score.name, score.kor, score.eng, score.math,
                score.sum, score.average);

    }
}

