import java.util.Scanner;

// Class representing the ATM machine
class ATM {
    float balance = 0; // Initial balance
    int PIN = 1234; // Predefined PIN for the ATM

    // Method to check the entered PIN
    public void checkpin() {
        System.out.println("Enter your PIN:");
        Scanner sc = new Scanner(System.in);
        int enteredPIN = sc.nextInt();
        if (enteredPIN == PIN) {
            menu(); // If PIN is correct, show the menu
        } else {
            System.out.println("Incorrect PIN"); // If PIN is incorrect, show an error message
            checkpin();
        }
    }

    // Method to display the menu options
    public void menu() {
        System.out.println("Enter your option:");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        // Switch statement to handle user option
        switch (option) {
            case 1:
                checkBal(); // Check account balance
                break;
            case 2:
                withdrawMoney(); // Withdraw money
                break;
            case 3:
                depositMoney(); // Deposit money
                break;
            case 4:
                return; // Exit
            default:
                System.out.println("Enter a valid option");
                menu();  // Recursively call the menu again if invalid option is entered
                break;
        }
    }

    // Method to check and display the account balance
    public void checkBal() {
        System.out.println("Balance: " + balance);
        menu(); // Return to the menu after displaying the balance
    }

    // Method to withdraw money from the account
    public void withdrawMoney() {
        System.out.println("Enter amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - amount;
            System.out.println("Money withdrawn successfully");
        }
        menu(); // Return to the menu after the transaction
    }

    // Method to deposit money into the account
    public void depositMoney() {
        System.out.println("Enter the amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance = balance + amount;
        System.out.println("Money deposited successfully");
        menu(); // Return to the menu after the transaction
    }
}

// Main class to run the ATM machine program
public class ATMMachine {
    public static void main(String[] args) {
        ATM obj = new ATM(); // Create an instance of the ATM class
        obj.checkpin(); // Start the PIN checking process
    }
}
