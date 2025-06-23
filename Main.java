import java.util.*;

public class Main {
    private static final int USER_PIN = 1234;
    private static double accountBalance = 1000.00;
    private static List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("************************************");
        System.out.println("      Welcome to Java ATM");
        System.out.println("************************************");

        System.out.print("Enter your 4-digit PIN: ");
        int inputPin = sc.nextInt();

        if (inputPin != USER_PIN) {
            System.out.println("❌ Incorrect PIN. Access Denied.");
            return;
        }

        System.out.println("✅ PIN Verified. Login Successful!\n");

        int choice;
        do {
            System.out.println("\n========= ATM MENU =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(sc);
                    break;
                case 3:
                    withdrawMoney(sc);
                    break;
                case 4:
                    showMiniStatement();
                    break;
                case 5:
                    System.out.println("👋 Thank you for using Java ATM!");
                    break;
                default:
                    System.out.println("⚠️ Invalid option. Please choose 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }

    private static void checkBalance() {
        System.out.printf("💰 Your Current Balance: ₹%.2f\n", accountBalance);
    }

    private static void depositMoney(Scanner sc) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("⚠️ Invalid deposit amount.");
            return;
        }

        accountBalance += amount;
        System.out.printf("✅ ₹%.2f deposited successfully.\n", amount);
        transactionHistory.add("Deposited: ₹" + amount);
    }

    private static void withdrawMoney(Scanner sc) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("⚠️ Invalid withdrawal amount.");
        } else if (amount > accountBalance) {
            System.out.println("⚠️ Insufficient balance.");
        } else {
            accountBalance -= amount;
            System.out.printf("✅ ₹%.2f withdrawn successfully.\n", amount);
            transactionHistory.add("Withdrawn: ₹" + amount);
        }
    }

    private static void showMiniStatement() {
        System.out.println("📄 Mini Statement:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions made yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println("• " + transaction);
            }
        }
    }
}
