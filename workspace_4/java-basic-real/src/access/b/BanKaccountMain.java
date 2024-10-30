package access.b;

import access.BankAccount;

public class BanKaccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(10000);
        account.withdraw(2000);
        System.out.println(account.getBalance());
    }
}
