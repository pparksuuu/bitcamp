// Stack 구현과 사용
package step12.ex03;

import java.util.Stack;

public class Exam01_2 {
    public static void main(String[] args) {
        
        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
        
        Stack stack = new Stack();
        stack.push(s1);
        print(stack);
        stack.push(s2);
        print(stack);
        stack.push(s3);
        print(stack);
        
        System.out.println("==================");
        
        System.out.println("==>" + stack.pop());
        print(stack);
        System.out.println("==>" + stack.pop());
        print(stack);
        
        System.out.println("==================");
        
        stack.push(s4);
        print(stack);
        stack.push(s5);
        print(stack);
        
        System.out.println("==================");
        
        String value;
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        } 
    }
    
    static void print(Stack list) {
        for (int i = 0; i <list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
