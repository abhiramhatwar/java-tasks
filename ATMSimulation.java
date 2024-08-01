import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: INR %.2f\n", account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: INR ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.printf("INR %.2f has been deposited successfully.\n", amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: INR ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            if (account.withdraw(amount)) {
                System.out.printf("INR %.2f has been withdrawn successfully.\n", amount);
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); 
        ATM atm = new ATM(userAccount);
        System.out.println("Welcome to the ATM!");
        atm.start();
    }
}
