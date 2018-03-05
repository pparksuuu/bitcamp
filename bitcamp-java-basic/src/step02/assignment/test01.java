package step02.assignment;

public class test01 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard);


        String name;
        int s1 = 0, s2 = 0, s3 = 0, sum = 0;

        System.out.print("이름? ");
        name = KeyScan.nextLine();

        System.out.print("국어? ");
        s1 = KeyScan.nextInt();

        System.out.print("영어? ");
        s2 = KeyScan.nextInt();

        System.out.print("수학? ");
        s3 = KeyScan.nextInt();

        System.out.print(name + " ");
        System.out.print(s1 + " ");
        System.out.print(s2 + " ");
        System.out.print(s3 + " ");

        sum = s1 + s2 + s3;

        System.out.print(sum);
        System.out.print(" " + (float)((sum)/3));
        //System.out.print(" " + (float)(sum)/3.0);
        

    }
}