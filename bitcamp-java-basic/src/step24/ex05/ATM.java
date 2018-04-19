package step24.ex05;

public class ATM extends Thread {
    Account account;
    
    public ATM(String name, Account account) {
        super(name);
        this.account = account;
    }
    
    @Override
    public void run() {
        long money = 0;
        long sum = 0;
        
        while ((money = account.withdraw(100)) > 0) sum += money;
        
        System.out.printf("%s가 찾은 돈 : %d원\n", this.getName(), sum);
    }
}
