class BankAccount{
    private int accountNumber;
    private String accountHolderName;   
    private double balance;
    BankAccount(int accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

}
class Bank{
    BankAccount[] accounts = new BankAccount[5];
    int accountCount = 0;

    public void addAccount(BankAccount account) {
        if (accountCount < accounts.length) {
            accounts[accountCount] = account;
            accountCount++;
        } else {
            System.out.println("Bank is full");
        }
    }

    public void WithdrawMoney(int accountNumber,double amount) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                try{
                accounts[i].withdraw(amount);
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void displayAccounts() {
        for (int i = 0; i < accountCount; i++) {
            System.out.println("Account Number: " + accounts[i].getAccountNumber());
            System.out.println("Account Holder Name: " + accounts[i].getAccountHolderName());
            System.out.println("Balance: " + accounts[i].getBalance());
            System.out.println();
        }
    }
}
class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount account1 = new BankAccount(1001,"Alice", 5000);
        BankAccount account2 = new BankAccount(1002,"Bob", 3000);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.WithdrawMoney(1001, 6000);
        bank.WithdrawMoney(1002,1000);
        bank.displayAccounts();
    }

}
