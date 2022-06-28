package service;

import beans.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AccountService {
    static Scanner sc = new Scanner(System.in);
    public Account addAccount(String agencyCode,Client client, Account account){
        double balance;
        String tempOverdraft;
        boolean overdraft;
        System.out.println("Solde du compte: ");
        balance = sc.nextDouble();
        sc.nextLine();
        System.out.println("Autorisation découvert? : (O/N) ");
        tempOverdraft = sc.nextLine();
        tempOverdraft = tempOverdraft.toUpperCase();
        if (tempOverdraft.equals("O")) {
            overdraft = true;
        } else {
            overdraft = false;
        }
        if (account instanceof CurrentAccount) {
            return new CurrentAccount(agencyCode, client, balance, overdraft);
        } else if (account instanceof SavingsAccount) {
            return new SavingsAccount(agencyCode, client, balance, overdraft);
        }else if (account instanceof HomeSavings){
            return new HomeSavings(agencyCode, client, balance, overdraft);
        }else {
            System.out.println("ERREUR");
        }
        return account;
    }
    public void findAccount(ArrayList<Account>accounts){
        String accountNumber;
        int i;
        boolean flag=false;
        for(Account account:accounts){
            System.out.println(account.getAccountNumber());
        }
        System.out.println("Saisissez le numéro de compte");
        accountNumber = sc.nextLine();
        i=0;
        while (!flag && i < accounts.size()){
            if (accountNumber.equals(accounts.get(i).getAccountNumber())){
                flag=true;
                System.out.println(accounts.get(i));
            }
            i++;
        }
    }
    public void findAccountOfClient(ArrayList<Account>accounts, ArrayList<Client>clients){
        String idClient;
        int nbAccount=0, i=0;
        for(Client client:clients){
            System.out.println(client);
        }
        System.out.println("Saisissez l'id client:");
        idClient=sc.nextLine();
        do{
            if (idClient.equals(accounts.get(i).getClient().getClientId())){
                System.out.println(accounts.get(i));
                nbAccount++;
            }
            i++;
        }while (i<accounts.size() && nbAccount!=3);
    }
}
