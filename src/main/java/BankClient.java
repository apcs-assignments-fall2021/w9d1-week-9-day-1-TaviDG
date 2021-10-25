import java.util.Scanner;

public class BankClient {
    public static void processInput(String input, BankAccount account){
        Scanner scan = new Scanner(System.in);
        if (input.equals("withdraw")){
            System.out.println("How much would you like to withdraw?");
            int amount = scan.nextInt();
            account.withdraw(amount);
            System.out.println("done");
        }
        else if (input.equals("deposit")){
            System.out.println("How much would you like to deposit?");
            int amount = scan.nextInt();
            account.deposit(amount);
            System.out.println("done");
        }
        else if (input.equals("apply interest")){
            account.applyInterest();
            System.out.println("Interest applied. Your balance is now " + account.getBalance());

        }
        else if (input.equals("upgrade interest")){
            System.out.println("Do you wish to pay $100 to upgrade your interest by 0.5% ? yes/no");
            if (scan.nextLine().equals("yes")){
                account.upgradeInterest();
            }
            System.out.println("done");
        }
        else if (input.equals("check balance")){
            System.out.println("Balance: " + account.getBalance());
        }
        else if (input.equals("check account number")){
            System.out.println("Account number: " + account.getAccountNumber());
        }
        else if (input.equals("check interest")){
            System.out.println("Interest: " + account.getInterest()+"%");
        }
        else if (input.equals("set preferred name")){
            System.out.println("What is your preferred name?");
            String name = scan.nextLine();
            account.setPreferredName(name);
        }
        else if (input.equals("print summary")){
            System.out.println(account.toString());
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your preferred name?");
        String name = scan.nextLine();
//        // Create a bank account with the given name and the account number 101134
        BankAccount account = new BankAccount(101134,name,0.005);
        String input = "";
        while (!(input.equals("close account"))){
            System.out.println("Hi, " + account.getPreferredName()+ "! What command would you like to carry out? (withdraw/deposit/apply interest/upgrade interest/check balance/check account number/check interest/set preferred name/print summary/close account)");
            input = scan.nextLine();
            processInput(input, account);
        }
    }
}
