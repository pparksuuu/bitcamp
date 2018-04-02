//App과 Controller 사이의 호출 규칙
package bitcamp.java106.pms.controller;

public interface Controller {
    //규칙 1:
    //사용자가 명령어를 입력하면 App 클래스는 해당 명령어를 찾아 service를 호출
    void service(String menu, String option);
}
