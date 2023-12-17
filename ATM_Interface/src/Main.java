import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBal) {
        this.balance = initialBal;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}


class ATM {
    private BankAccount userAcc;

    public ATM(BankAccount account) {
        this.userAcc = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (userAcc.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful");
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = scanner.nextDouble();
                    userAcc.deposit(depositAmt);
                    System.out.println("Deposit successful");
                    break;
                case 3:
                    System.out.println("Your balance is: " + userAcc.getBalance());
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}


public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}