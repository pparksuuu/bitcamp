//패키지
//소스 파일이 놓이는 루트 폴더의 하위 폴더명을 적어야 한다.
//src폴더는 루트폴더 -> 패키지명에 포함 X.
package step00_WooAh;
import java.util.Stack;

public class Exam02_1 {
    public static void solution(String S) {
        Stack<Integer> stack = new Stack<>();

        if ((S.length() <2000)) {

            String[] arr = S.split(" ");

            for (String arrs : arr) {
                if (isInteger(arrs)) {
                    
                    Integer a = Integer.parseInt(arrs);
                    
                    stack.push(a);
                    //System.out.println(stack.pop());
                }
            }
            Integer a = stack.pop();
            Integer b = stack.pop();
            Integer result = (stack.pop() + stack.pop());
            System.out.println(result);
            //            stack.push(arr[0]);
        }

        //        if (!isInteger(arr[0])) {
        //            return -1;
        //        } else {
        //            return calculate(arr);
        //        }
    }

    public static int calculate(String[] arr) {
        Stack stack = new Stack();
        //int result = 0;


        for (int i = 0; i < arr.length; i++) {
            if (isInteger(arr[i])) {
                Integer.parseInt(arr[i]);
                stack.push(arr[i]);
            } else {
                switch (arr[i]) {
                case "DUP":
                    int dupInt = (int) stack.pop();
                    stack.push(dupInt);
                    stack.push(dupInt);
                case "POP":
                    stack.pop();
                case "+":
                    int first_p = (int) stack.pop();
                    int second_p = (int) stack.pop();
                    int plus = first_p + second_p;
                    stack.push(plus);
                case "-":
                    int first_m = (int) stack.pop();
                    int second_m = (int) stack.pop();
                    int minus = first_m - second_m;
                    stack.push(minus);
                }
            }
        }
        return (int) stack.pop();
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

        //int result = solution("13 DUP 4 POP 5 DUP + DUP + -");
        solution("13 12 DUP 4 POP 5 DUP + DUP + -");
    }
}

//클래스들을 분류하기 위한 문법 "패키지"