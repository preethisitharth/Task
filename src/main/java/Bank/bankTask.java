package Bank;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
    // Custom exception for insufficient funds
    class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    // Class representing a bank account
    class BankAccount {
        private double balance;
        private List<String> transactions;

        public BankAccount() {
            this.balance = 0.0;
            this.transactions = new ArrayList<>();
        }

        // Method to deposit money into the account
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactions.add("Deposited: $" + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        // Method to withdraw money from the account
        public void withdraw(double amount) throws InsufficientFundsException {
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (amount > balance) {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            } else {
                balance -= amount;
                transactions.add("Withdrew: $" + amount);
            }
        }

        // Method to view account balance
        public void viewBalance() {
            System.out.println("Current balance: $" + balance);
        }

        // Method to view all transactions
        public void viewTransactions() {
            if (transactions.isEmpty()) {
                System.out.println("No transactions found.");
            } else {

            }
            System.out.println("Transaction history:");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

// Main class to run the banking application
public class bankTask{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount();

        boolean running = true;
        while (running) {
            System.out.println("\nBanking Application Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        try {
                            account.withdraw(withdrawalAmount);
                        } catch (InsufficientFundsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        account.viewBalance();
                        break;

                    case 4:
                        account.viewTransactions();
                        break;

                    case 5:
                        running = false;
                        System.out.println("Thanks for banking");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close();
    }
}

