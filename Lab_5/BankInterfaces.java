interface BankInterface {
    double getBalance();

    double getInterestRate();
}
class BankA implements BankInterface {
    private double balance;
    public BankA(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return 0.07; 
    }
}
class BankB implements BankInterface {
    private double balance;
    public BankB(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return 0.074;
    }
}
class BankC implements BankInterface {
    private double balance;
    public BankC(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 0.079; // 7.9% interest rate for BankC
    }
}

public class BankInterfaces {
    public static void main(String[] args) {
        BankA bankA = new BankA(10000);
        BankB bankB = new BankB(150000);
        BankC bankC = new BankC(200000);
        System.out.println("Bank A:");
        System.out.println("Balance: $" + bankA.getBalance());
        System.out.println("Interest Rate: " + (bankA.getInterestRate() * 100) + "%\n");
        System.out.println("Bank B:");
        System.out.println("Balance: $" + bankB.getBalance());
        System.out.println("Interest Rate: " + (bankB.getInterestRate() * 100) + "%\n");
        System.out.println("Bank C:");
        System.out.println("Balance: $" + bankC.getBalance());
        System.out.println("Interest Rate: " + (bankC.getInterestRate() * 100) + "%");
    }
}