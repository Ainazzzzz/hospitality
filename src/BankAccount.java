public class BankAccount {
    private int accountNumber;
    private double balance;
    private int cvv;
    private String fullName;

    public BankAccount(int accountNumber, double balance, int cvv, String fullName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.cvv = cvv;
        this.fullName = fullName;
    }

    public String deposit(double amount) {
        this.balance +=amount;
        return "Успешно внесены деньги " + amount;
    }

    public String withdraw(double amount, int cvv) {
        if(cvv == this.cvv && balance >= amount){
            this.balance -= amount;
        }else {
            return "Недостаточно средств либо неправильный cvv";
        }
        return "Успешно сняты деньги " + amount ;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", cvv=" + cvv +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
