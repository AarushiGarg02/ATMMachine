import java.util.Scanner;

public class atmmachine {

    private static double balance = 1000.0;  // Initial balance
    private static int pin = 4893;

    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        // Check if the entered PIN is correct
        if (enteredPin != pin) {
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            // ATM menu
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            int option = sc.nextInt();

            switch (option) {
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
                    changePin(sc);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        sc.close();
    }

    // Method to check balance
    private static void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    // Method to deposit money
    private static void depositMoney(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();


        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
            System.out.println("Current balance :" + balance);
        }
    }

    // Method to withdraw money
    private static void withdrawMoney(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew : " + amount);
            System.out.println("Current Balance : " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to change PIN
    private static void changePin(Scanner sc) {
        System.out.print("Enter your current PIN: ");
        int currentPin = sc.nextInt();

        if (currentPin == pin) {
            System.out.print("Enter new PIN: ");
            int newPin = sc.nextInt();

            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect PIN. Cannot change PIN.");
        }
    }
}