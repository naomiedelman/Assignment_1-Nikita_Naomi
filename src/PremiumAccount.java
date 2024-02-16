public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double balance;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0; // Initial balance set to 0
    }
    @Override
    public void Deposit(double amount) {
        this.balance += amount;

    }

    @Override
    public double Withdraw(double amount) {
        balance -= amount; // Deduct the withdrawal amount from balance
        return amount; // Return the withdrawn amount
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }

}

