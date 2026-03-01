package br.com.renandoring.banckaccount;
import java.util.Scanner;

public class BankAccount {
    String clienteName = "Renan Doring";
    String accountType = "Corrente";
    private double accountNumber = 5555.00;
    private double accountBalance = 50000.00;
    String enterValue = "";

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void clientData() {

        System.out.println("**************************************************\n" +
                "Initial data of client: \n\n" +
                "Name: " + "              " + clienteName + "\n" +
                "Account Type: " + "      " + accountType + "\n" +
                "Account Balance:    R$ " + getAccountBalance() + "\n" +
                "Account Number:     " + getAccountNumber() + "\n" +
                "**************************************************\n");

        Scanner input = new Scanner(System.in); //Scanner não entra no looping

        while (!enterValue.equals("4")) {
            System.out.println("\nOperations \n");
            System.out.println("Please choice a operation: \n\n" +
                    "1 - Check balance\n" +
                    "2 - Receive value\n" +
                    "3 - Transfer value\n" +
                    "4 - Finish");
            enterValue = input.nextLine();

            switch (enterValue) {
                case "1":
                    System.out.printf("The actual balance is R$: %.2f\n", accountBalance);
                    break;

                case "2":
                    System.out.println("Enter the amount you want to deposit");
                    double depositValue = input.nextDouble();
                    if (depositValue > 0) {
                        double actualBalance = accountBalance + depositValue;
                        accountBalance = actualBalance;
                        System.out.printf("The actual balance is R$: %.2f\n", actualBalance);
                    }
                    break;

                case "3":
                    System.out.println("Enter the amount you want to transfer");
                    double transferValue = input.nextDouble();
                    if (transferValue > 0 && accountBalance >= transferValue) {
                        double actualBalance = accountBalance - transferValue;
                        accountBalance = actualBalance;
                        System.out.printf("The actual balance is R$: %.2f\n", actualBalance);
                    } else {
                        System.out.println("Insufficient funds!");
                    }
                    break;

                case "4":
                    System.out.println("Finish");
                    break;

                default:
                    System.out.println("Enter the valid number");
            }
        }
        input.close();
        System.out.println("Program finished!");
    }
}
