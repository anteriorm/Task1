import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
public class BankAccount {

    public String number;

    public String name;

    public int balance;

    public LocalDateTime date;

    public boolean block;

    public String toString(){
        return "Владелец: " + name +
                ", Баланс: " + balance +
                ", Дата открытия: " + date +
                ", Заблокирован: " + (block ? "Да" : "Нет") +
                ", Номер счёта: " + number;
    }

    public BankAccount(String name){
        Random random = new Random();
        number = "";
        for (int i = 0; i < 8; i++){
            number += random.nextInt(10);
        }

        this.name = name;

        this.date = LocalDateTime.now();

        this.balance = 0;

        this.block = false;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAccount other = (BankAccount) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean deposit(int money){
        if (!block && money > 0){
            balance += money;
            return true;
        }else{
            return false;
        }

    }


    public boolean withdraw(int money){
        if (!block && money > 0){
            if (money <= balance){
                balance -= money;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean transfer(BankAccount otherAccount,int amount){
        if (!block && !otherAccount.block){
            if (amount <= balance){
                balance -= amount;
                otherAccount.balance += amount;
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

}
