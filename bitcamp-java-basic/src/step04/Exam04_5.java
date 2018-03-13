// 비트 이동 연산자 : 응용2 -실무에서 한다.
package step04;

public class Exam04_5 {
    public static void main(String[] args) {
        //Yes/No 또는 true/false 값을 저장할 때
        //비트 연산자를 사용하면 메모리를 절약할 수 있다.

        //비트 연산자 사용 전
        //=> 각각의 상태를 별도의 변수에 저장해야 한다.
        //=> 8개의 데이터를 저장하기 위해 32바이트가 소요된다.
        boolean c, cpp, java, js, python, php, html, css;
        c = true;
        cpp = false;
        java = true;
        js = false;
        python = true;
        php = false;
        html = true;
        css = false;

        //물론 배열을 이용할 수 있다.
        //boolean 배열을 JVM에서 다룰 떄는 각 boolean 에 대해
        //1바이트를 사용한다.
        //따라서 8바이트를 사용
        boolean[] lang = new boolean[8];
        lang[0] = true;
        lang[1] = false;
        lang[2] = true;
        lang[3] = false;
        lang[4] = true;
        lang[5] = false;
        lang[6] = true;
        lang[7] = false;

        //비트 연산자 사용 후
        //=> 4바이트 변수 한 개만 있으면 
        //최대 32개의 데이터를 저장할 수 있다.
        //어떻게?
        int lang2 = 0;
        lang2 |= 0x80; //c = true 

        //lang2 |= 0x00; //c++ = false 

        lang2 |= 0x20; // java = true

        //lang2 |= 0x00; //js = false         

        lang2 |= 0x08;//python = true
        

        //lang2 = 0x00; //php = false;

        lang2 |= 0x04; //html = true

        //lang2 - 0x00; //css = false

        System.out.println(lang2);

    }
}

