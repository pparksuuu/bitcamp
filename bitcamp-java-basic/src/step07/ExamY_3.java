//메서드 분류 - 클래스 변수의 단점
package step07;


public class ExamY_3 {
    public static void main(String[] args) {
        //클래스 변수는 오직 한 개만 존재하기 떄문에
        //여러 개의 작업을 분리하여 진행할 수 없다.
        
        //다음 두 개의 식을 분리하여 계산해 보자!
        //1) 2 + 3 - 1 * 7 / 3 = ?
        //2) 3 * 2 + 7 / 4 - 5 = ?
        // 1) 과 2) 동시에 계산 불가능.
        
        //Calculator2는 계산 결과를 저장하는 변수가 한개여서
        //식1과 식2를 개별적으로 동시에 계산할 수 없다.
        Calculator2.plus(2);
        Calculator2.plus(3);
        
        Calculator2.plus(3);
        Calculator2.multiple(2);
        
        Calculator2.minus(1);
        Calculator2.plus(7);
        
        Calculator2.multiple(7);
        Calculator2.divide(4);
        
        Calculator2.divide(3);
        Calculator2.minus(5);
        
        System.out.printf("result = %d\n", Calculator2.result);
    }
}

