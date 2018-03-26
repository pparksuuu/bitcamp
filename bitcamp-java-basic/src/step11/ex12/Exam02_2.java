//Object 클래스의 메서드를 오버라이딩 하기 - hashCode()
package step11.ex12;

public class Exam02_2 {
    
    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        
        public Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this.sum = this.kor + this.eng + this. math;
            this.aver = this.sum / 3f;
        }
        
        // 인스턴스가 다르더라도 값이 같으면 같은 해시 값을 리턴하도록 오버라이딩 해보자!
        @Override
        public int hashCode() {
            // 가장 간단한 방법은 모든 값을 문자열로 만들어 붙인 다음에
            // String 클래스에 있는 hashCode()를 사용하는 것이다.
            // 왜? String 클래스에 있는 hashCode()는 문자열이 같은 경우
            // 같은 해시 값을 리턴하도록 오버리딩 되어 있기 때문이다.
            String value = String.format("%s, %d, %d, %d, %d, %.1f",
                    this.name, this.kor, this.eng, this.math,
                    this.sum, this.aver);
            return value.hashCode();
        }
    }
    
    public static void main(String[] args) {
        Score s1 = new Score("홍길동", 100, 100, 100);
        Score s2 = new Score("홍길동", 100, 100, 100);
        
        // Object에서 상속 받아 사용하는 hashCode()는
        // 기본적으로 인스턴스마다 고유의 값을 리턴한다.
        // 주의 ! 인스턴스 주소가 아니다 !
        // 그래서 다음 출력은 비록 같은 값을 갖고 있다 하더라도
        // 인스턴스가 다르기 때문에 해시코드의 값이 다르다 !
        System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode());
        
        System.out.println(s1.hashCode() == s2.hashCode());
        
        System.out.println(s1.equals(s2));
   
        
    }

}
