package step02.assignment;

public class test01 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard);


        //String name = null;
        // int kor = 0, eng = 0, math = 0, sum = 0;

        System.out.print("이름? ");
        String name = KeyScan.nextLine();

        System.out.print("국어? ");
        int kor = KeyScan.nextInt();

        System.out.print("영어? ");
        //이전에 국어 점수를 입력받을 때 들어온 줄바꿈 코드는 
        //nextInt() 메서드에서 버린다.
        int eng = KeyScan.nextInt();

        System.out.print("수학? ");
        int math = KeyScan.nextInt();

        System.out.println("===============");

        System.out.print(name + " ");
        System.out.print(kor + " ");
        System.out.print(eng + " ");
        System.out.print(math + " ");

        //int sum = kor + eng + math;
        float average = sum / 3;

        System.out.print(sum);
        System.out.println(" " + avaerage);
       // System.out.print(" " + (float)((sum)/3));
        //System.out.print(" " + (float)(sum)/3.0);
        

    }
}