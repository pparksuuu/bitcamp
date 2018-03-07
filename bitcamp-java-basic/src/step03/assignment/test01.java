package step03.assignment;

public class test01 {
    public static void main(String[] args) {
        
        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }
        
        Score arr[] = new Score[3];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new Score();
        }
        
        
        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard);


        for(int i = 0; i < arr.length; i++) {
            System.out.print("입력: ");
            arr[i].name = KeyScan.next();
            arr[i].kor = KeyScan.nextInt();
            arr[i].eng = KeyScan.nextInt();
            arr[i].math = KeyScan.nextInt();
            arr[i].sum = arr[i].kor + arr[i].eng + arr[i].math;
            arr[i].aver = arr[i].sum / 3;
        }

        System.out.println("======================");
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("%-5s %3d %3d %3d %3d %4.1f\n", arr[i].name, arr[i].kor,
             arr[i].eng, arr[i].math, arr[i].sum, arr[i].aver);
        }
    }
}