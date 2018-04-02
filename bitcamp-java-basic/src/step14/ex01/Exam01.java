package step14.ex01;

public class Exam01 {
    public static void main(String[] args) {
        Worker w1 = new BlueWorker();
        Worker w2 = new WhiteWorker();
        Worker w3 = new JubuWorker();
        
        w1.execute();
        w2.execute();
        w3.execute();
        
        // 역할?
        // caller : Exam01
        // callee : BlueWorker, WhiteWorker, JubuWorker
        // 규칙 : Worker
    }
}
