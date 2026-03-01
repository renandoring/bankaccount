import br.com.renandoring.banckaccount.BankAccount;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("Satoru Gojo","Corrente", 220.09, 50000.00, "3");
        BankAccount bankAccount1 = new BankAccount("Yuji Itadori", "Poupança", 1233.02, 1000.00, "2");
        BankAccount bankAccount2 = new BankAccount("Yuta Okkotsu", "Corrente", 6548.84, 6500.00, "4");

        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

        bankAccounts.add(bankAccount);
        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);

        try {
            BankAccount account = new BankAccount("", "",0,0,"");

            System.out.println("Enter yout ID:");
            account.continueForClientData(bankAccounts);

            //Browse the entire list
            bankAccount.continueForClientData(bankAccounts);

            for (BankAccount bankAccount3 : bankAccounts) {
                System.out.println(bankAccount3);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }
}