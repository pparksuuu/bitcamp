//인스턴스 변수
package step08;

public class Exam01_2 {

    public static void main(String[] args) {
        // 1)성적 데이터를 설계할 클래스이기 때문에 그에 맞는 클래스명을 사용하라
        class Score {
           String name;   //"각각 구분"되는 애들이기 때문에 instance 변수로 만든다. -> Heap에 저장.
           int kor;
           int eng;
           int math;
           int sum;
           float average;
        }
        
        Score s1 = new Score();
        Score s2 = new Score();
        Score s3 = new Score();
        
        s1.name = "홍길동";
        s1.kor = 100;
        s1.eng = 90;
        s1.math = 80;
        s1.sum = s1.kor + s1.eng + s1.math;
        s1.average = s1.sum / 3f;
        
        s2.name = "임꺽정";
        s2.kor = 90;
        s2.eng = 70;
        s2.math = 60;
        s2.sum = s2.kor + s2.eng + s2.math;
        s2.average = s2.sum / 3f;
        
        s3.name = "유관순";
        s3.kor = 90;
        s3.eng = 70;
        s3.math = 60;
        s3.sum = s3.kor + s3.eng + s3.math;
        s3.average = s3.sum / 3f;
    }

}

//
