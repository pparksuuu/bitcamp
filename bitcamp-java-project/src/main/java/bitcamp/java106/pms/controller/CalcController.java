package bitcamp.java106.pms.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;

@Component("calc")
public class CalcController implements Controller {
    Scanner keyScan;



    public CalcController(Scanner scanner) {
        keyScan = scanner;
    }

    public void service(String menu, String option) throws InputMismatchException{

        System.out.print("식을 입력하세요?");
        
        
        String[] arr = keyScan.nextLine().split(" ");
        try {
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String op = arr[1];
        

            switch (op) {
            case "+": 
                System.out.printf("%d %s %d = %d", a, op, b, a + b);  
                return;
            case "-":
                System.out.printf("%d %s %d = %d", a, op, b, a - b);
                return;
            case "*":
                System.out.printf("%d %s %d = %d", a, op, b, a * b);
                return;
            case "/":
                System.out.printf("%d %s %d = %d", a, op, b, a / b);
                return;
            case "%":
                System.out.printf("%d %s %d = %d", a, op, b, a % b);
                return;
            default: 
                throw new InputMismatchException("해당 연산자를 지원하지 않습니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("INPUTMISMATCH");
            keyScan.nextLine(); // 입력이 잘못 되었을 경우 나머지 입력을 무시한다.
        }
    }

}
