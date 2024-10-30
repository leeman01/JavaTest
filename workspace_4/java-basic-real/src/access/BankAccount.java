package access;

public class BankAccount {
    private int balance;

    public BankAccount() {
        balance=0;
    }
    // public method 입금
    public void deposit(int amount){
        if(isAmountValue(amount)){
            balance+=amount;
        }else{
            System.out.println("유효하지 않음 근액");
        }


    }
    private boolean isAmountValue(int amount){
        // 금액이 0보다 커야히디
        return amount>0;
    }
    // 입금 메소드
    public void withdraw(int amount){
        if (isAmountValue(amount) && balance-amount>=0){
            balance-=amount;
        }else{
            System.out.println("유효하지않은 금액이거나 잔액부족");
        }
    }
    // public method
    public int getBalance(){
        return balance;
    }
}
