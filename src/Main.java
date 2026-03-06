import br.com.renandoring.banckaccount.BankAccount;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

        BankAccount bankAccount = new BankAccount("Satoru Gojo","Corrente", 220.09, 50000.00, "3");
        BankAccount bankAccount1 = new BankAccount("Yuji Itadori", "Poupança", 1233.02, 1000.00, "2");
        BankAccount bankAccount2 = new BankAccount("Yuta Okkotsu", "Corrente", 6548.84, 6500.00, "4");
        BankAccount bankAccount3 = new BankAccount("Goku","Corrente", 224.09, 50400.00, "8");
        BankAccount bankAccount4 = new BankAccount("Vegeta", "Poupança", 1233.02, 1060.00, "9");
        BankAccount bankAccount5 = new BankAccount("Gohan", "Corrente", 658.84, 6580.00, "1");

        bankAccounts.add(bankAccount);
        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);
        bankAccounts.add(bankAccount3);
        bankAccounts.add(bankAccount4);
        bankAccounts.add(bankAccount5);

   /*     try {
            BankAccount account = new BankAccount("", "",0,0,"");

            System.out.println("Enter yout ID:");
            account.continueForClientData(bankAccounts);

            //Browse the entire list
            bankAccount.continueForClientData(bankAccounts);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }*/

        for (BankAccount bankAccountTeste : bankAccounts) {
            System.out.println(bankAccountTeste);
        }

        try (FileWriter escrita = new FileWriter("bankaccount.json")) {
            escrita.write(gson.toJson(bankAccounts));
            escrita.close();
            System.out.println("Bank account has been saved successfully");
            System.out.println("Size of bank account: " + bankAccounts.size());
        } catch (IOException ex) {
            System.out.println("Error writing bank account");
        }
    }
}