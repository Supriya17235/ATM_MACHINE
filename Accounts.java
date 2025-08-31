package atm_operations;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance += amount;
        return savingBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter the amount you want to withdraw: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("Withdrawal Successful!");
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient funds. Transaction cancelled.");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Savings Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter the amount you want to withdraw: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("Withdrawal Successful!");
            System.out.println("New Savings Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient funds. Transaction cancelled.");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter the amount you want to deposit: ");
        double amount = input.nextDouble();

        if (amount > 0) {
            calcCheckingDeposit(amount);
            System.out.println("Deposit Successful!");
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Invalid amount. Transaction cancelled.");
        }
    }

    public void getSavingDepositInput() {
        System.out.println("Savings Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter the amount you want to deposit: ");
        double amount = input.nextDouble();

        if (amount > 0) {
            calcSavingDeposit(amount);
            System.out.println("Deposit Successful!");
            System.out.println("New Savings Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Invalid amount. Transaction cancelled.");
        }
    }
}
