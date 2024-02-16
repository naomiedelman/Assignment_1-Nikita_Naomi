public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit; // No credit limit, withdrawal limit only

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0; // Starting balance is set to 0
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double actualWithdrawnAmount = Math.min(amount, withdrawalLimit);
        if (balance >= actualWithdrawnAmount) {
            balance -= actualWithdrawnAmount;
            return actualWithdrawnAmount;
        } else {
            return 0; // If insufficient balance, no withdrawal is made
        }
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