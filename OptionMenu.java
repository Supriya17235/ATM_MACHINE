package atm_operations;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(192211351, 1351);
                data.put(192211353, 1353);

                System.out.print("\nEnter your customer number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN number: ");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\nInvalid input. Only numbers are allowed.\n");
                menuInput.nextLine();
                continue;
            }

            if (data.containsKey(getCustomerNumber()) && data.get(getCustomerNumber()) == getPinNumber()) {
                getAccountType();
                x = 2;
            } else {
                System.out.println("\nWrong Customer Number or PIN. Try again.\n");
            }

        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("\nSelect the account you want to access: ");
        System.out.println(" Type 1 - Checking Account");
        System.out.println(" Type 2 - Savings Account");
        System.out.println(" Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("\nThank you for using this ATM. Goodbye!\n");
                break;
            default:
                System.out.println("\nInvalid choice.\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("\nChecking Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("\nInvalid choice.\n");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("\nSavings Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("\nInvalid choice.\n");
                getSaving();
        }
    }
}
