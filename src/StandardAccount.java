public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0; // Assume starting balance is 0
        this.creditLimit = creditLimit; // Set the credit limit
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;

    }

    @Override
    public double Withdraw(double amount) {
        double maxAvailable = balance + Math.abs(creditLimit); // Total available includes the credit
        double actualWithdrawnAmount = Math.min(amount, maxAvailable);
        balance -= actualWithdrawnAmount; // Update the balance
        return actualWithdrawnAmount; // Return the actual withdrawn amount
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