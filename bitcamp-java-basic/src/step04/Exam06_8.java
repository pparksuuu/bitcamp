// 증감 연산자 : 전위(pre-fix) 증감 연산자 응용 II
package step04;

public class Exam06_8 {
    public static void main(String[] args) {
        int i = 2;
        int result = ++i + ++i * ++i;
        //1) int result = 3 + 4 * 5
        //2) int result = 3 + 20
        //3) int result = 23;

        System.out.println(result); //23

        //주의!
        // 1) pre-fix 연산자와 post-fix 연산자를 리터럴에 적용할 수 없다!
        //int x = ++100;//컴파일 오류 !
        //x = 100++;//컴파일 오류!

        // 2) 변수에 동시에 적용할 수 없다.
        int y = 100;
        //++y++;
        //(++y)++;//컴파일 오류  
        /*
        (++y)하고 나면 (값)을 놓는다 ! 그러면 1) 때문에 안되는거야.
        값에 ++ 할 수 없다고 !
        */
        //++(++y); //컴파일 오류
    }
}