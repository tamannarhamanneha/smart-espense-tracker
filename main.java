import java.util.ArrayList;
import java.util.Scanner;

// Abstract class (Abstraction)
abstract class Transaction {
    double amount;
    String category;

    Transaction(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    abstract double getAmount(); // polymorphism
}

// Income class
class Income extends Transaction {

    Income(double amount, String category) {
        super(amount, category);
    }

    double getAmount() {
        return amount; // positive
    }
}

// Expense class
class Expense extends Transaction {

    Expense(double amount, String category) {
        super(amount, category);
    }

    double getAmount() {
        return -amount; // negative
    }
}

// Main class
public class ExpenseTracker {

    static ArrayList<Transaction> list = new ArrayList<>();

    static void showAllTransactions() {
        System.out.println("\n=== All Transactions ===");
        for (Transaction t : list) {
            System.out.println(t.category + " : " + t.getAmount());
        }
    }

    static void showBalance() {
        double balance = 0;
        for (Transaction t : list) {
            balance += t.getAmount();
        }
        System.out.println("\nCurrent Balance: " + balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Show Balance");
            System.out.println("4. Show All Transactions");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter income amount: ");
                double amt = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter category: ");
                String cat = sc.nextLine();

                list.add(new Income(amt, cat));
            }

            else if (choice == 2) {
                System.out.print("Enter expense amount: ");
                double amt = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter category: ");
                String cat = sc.nextLine();

                list.add(new Expense(amt, cat));
            }

            else if (choice == 3) {
                showBalance();
            }

            else if (choice == 4) {
                showAllTransactions();
            }

        } while (choice != 5);

        System.out.println("Exit...");
    }
}

