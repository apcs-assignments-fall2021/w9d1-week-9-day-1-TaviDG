public class BankAccount {
    // Instance variables
    private double balance;
    private int accountNumber;
    private String preferredName;
    private double interest;
    public BankAccount(int accountNumber, String preferredName, double interest){
        this.accountNumber=accountNumber;
        this.preferredName=preferredName;
        this.interest=interest;
    }
    public void withdraw(int x){
        if (this.balance-x>=0){
            this.balance-=x;
        }
        else{
            System.out.println("You don't have enough money to withdraw that amount :(");
        }
    }
    public void deposit(int x){
        this.balance+=x;
    }
    public double getBalance(){
        return this.balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public String getPreferredName(){
        return preferredName;
    }
    public void setPreferredName(String name){
        this.preferredName=name;
    }
    public double getInterest(){
        return (this.interest*100);
    }
    public String toString(){
        return ("Account number "  + getAccountNumber() + " has a balance of " + getBalance() + " and an interest rate of " + getInterest()+"%");
    }
    public void applyInterest(){
        this.balance+=(this.interest*this.balance);
    }
    public void upgradeInterest(){
        this.balance-=100;
        this.interest+=0.005;
    }
}