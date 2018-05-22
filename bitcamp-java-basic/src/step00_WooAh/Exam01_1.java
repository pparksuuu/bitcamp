//패키지
//소스 파일이 놓이는 루트 폴더의 하위 폴더명을 적어야 한다.
//src폴더는 루트폴더 -> 패키지명에 포함 X.
package step00_WooAh;
import java.util.Stack;

public class Exam01_1 {
    public static int solution(String S) {
        if (!(S.length() <2000)) {
            return -1;
        }
        String[] arr = S.split(" ");

        if (!isInteger(arr[0])) {
            return -1;
        } else {
            return calculate(arr);
        }
    }

    
    
    public static int calculate(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        //int result = 0;

        try {
        
        for (int i = 0; i < arr.length; i++) {
            if (isInteger(arr[i])) {
                Integer pushInt = Integer.parseInt(arr[i]);
                stack.push(pushInt);
            } else {
                switch (arr[i]) {
                case "DUP":
                    Integer dupInt = stack.pop();
                    stack.push(dupInt);
                    stack.push(dupInt);
                    break;
                case "POP":
                    stack.pop();
                    break;

                case "+":
                    Integer plus =  (stack.pop() + stack.pop());
                    stack.push(plus);
                    break;

                case "-":
                    Integer minus =  (stack.pop() - stack.pop());
                    stack.push(minus);
                    break;

                }
            }
        }
        return (int) stack.pop();
        } catch (Exception e) {
            return -1;
        }
        
    }


    public static boolean isInteger(String S) {
        try {
            Integer.parseInt(S);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }




    public static void main(String[] args) {
        
        int result = solution("DUP");
        System.out.println(result);
    }
}

//클래스들을 분류하기 위한 문법 "패키지"