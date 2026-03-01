package br.com.renandoring.banckaccount;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    String clienteName;
    String accountType;
    private double accountNumber = 0;
    private double accountBalance = 0;
    private String myId;
    String enterValue = "";

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public String getClienteName() {
        return clienteName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getEnterValue() {
        return enterValue;
    }

    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }

    public BankAccount(String clienteName, String accountType, double accountNumber, double accountBalance, String myId) {
        this.clienteName = clienteName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.myId = myId;
    }

    public void continueForClientData(ArrayList<BankAccount> accounts) throws Exception {
        Scanner choiceInput = new Scanner(System.in);
        String choiceMyid = choiceInput.nextLine();

        boolean found = false;
        BankAccount selectedAccount = null;

        for (BankAccount account : accounts) {
            if (choiceMyid.equals(account.getMyId())) {
                found = true;
                selectedAccount = account;
                break;
            }
        }

        if (found) {
            System.out.println("You chose to continue" + " " + choiceMyid);
            System.out.println(selectedAccount.toString());
            boolean shouldFinish = selectedAccount.clientData();
            choiceInput.close();

            if (shouldFinish) {
                return;
            }

        } else {
            System.out.println("Invalid choice");
            choiceInput.close();
            throw new Exception("Escolha inválida - encerrando programa");
        }
    }

    public boolean clientData() {
        Scanner input = new Scanner(System.in); //Scanner não entra no looping
        String enterValue = "";

        while (true) {
            System.out.println("\nOperations \n");
            System.out.println("Please choice a operation: \n\n" +
                    "1 - Check balance\n" +
                    "2 - Receive value\n" +
                    "3 - Transfer value\n" +
                    "4 - Finish");
            enterValue = input.nextLine();

            switch (enterValue) {
                case "1":
                    System.out.printf("The actual balance is R$: %.2f\n", getAccountBalance());
                    break;

                case "2":
                    System.out.println("Enter the amount you want to deposit");
                    double depositValue = input.nextDouble();
                    if (depositValue > 0) {
                        double actualBalance = getAccountBalance() + depositValue;
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
                    input.close();
                    return true; //Get out of method

                default:
                    System.out.println("Enter the valid number");
            }
        }
    }

    public String toString() {
        return "**************************************************" +
                "\nInitial data of client: \n\n" +
                "Name: " + "              " + getClienteName() + "\n" +
                "Account Type: " + "      " + getAccountType() + "\n" +
                "Account Balance:    R$ " + getAccountBalance() + "\n" +
                "Account Number:     " + getAccountNumber() + "\n" +
                "**************************************************\n";
    }
}
