public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Миша");
        System.out.println(account.block);
        BankAccount acc1 = new BankAccount("Миша");
        BankAccount acc2 = new BankAccount("Катя");

        acc1.deposit(999);
        System.out.println(acc1.balance);

        acc1.withdraw(150);
        System.out.println(acc1.balance);

        acc1.transfer(acc2, 149);

        System.out.println(acc1);
        System.out.println(acc2);

        System.out.println(acc1.equals(acc2));


    }
}