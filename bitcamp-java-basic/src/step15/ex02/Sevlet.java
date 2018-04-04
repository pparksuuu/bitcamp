package step15.ex02;

public interface Sevlet {
    void init();
    void service();
    void destroy();
    String getServletInfo();
    String getServletConfig();
}
