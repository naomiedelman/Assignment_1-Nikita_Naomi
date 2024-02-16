import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank implements IBank {
    private List<IAccount> accounts; // List to hold account objects

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // Method to open an account and add it to the bank's list of accounts
    public void OpenAccount(IAccount account) {
        accounts.add(account);
    }

    // Method to close an account based on account number
    public void CloseAccount(int accountNumber) {
        IAccount account = accounts.stream()
                .filter(a -> a.GetAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);
        if (account != null) {
            if (account.GetCurrentBalance() >= 0) {
                accounts.remove(account);
            } else {
                System.out.println("Account " + accountNumber + " cannot be closed due to debt.");
            }
        }
    }

    // Method to get all accounts
    public List<IAccount> GetAllAccounts() {
        return new ArrayList<>(accounts);
    }

    // Method to get all accounts in debt (negative balance)
    public List<IAccount> GetAllAccountsInDebt() {
        return accounts.stream()
                .filter(a -> a.GetCurrentBalance() < 0)
                .collect(Collectors.toList());
    }

    // Method to get all accounts with balance above a certain threshold
    public List<IAccount> GetAllAccountsWithBalance(double balance) {
        return accounts.stream()
                .filter(a -> a.GetCurrentBalance() > balance)
                .collect(Collectors.toList());
    }

    // Implement other necessary methods and logic here
}