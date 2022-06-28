package beans;

import java.util.ArrayList;
import java.util.SortedMap;

public abstract class Account{
    public static ArrayList<String>accountNumberAlreadyUse = new ArrayList<>();
    private String accountNumber;
    private String agencyCode;
    private Client client;
    protected double balance;
    private boolean overdraft;
    protected double fees;

    public Account(String agencyCode, Client client, double balance, boolean overdraft){
        String tempAccountNumber;
        long cAccountNumber;
        boolean flag=false, check=false;
        int i=0;
        do {
            cAccountNumber=Math.round(Math.random()*10E10);
            if (cAccountNumber<10){
                tempAccountNumber="0000000000"+cAccountNumber;
            } else if (cAccountNumber<100) {
                tempAccountNumber="000000000"+cAccountNumber;
            } else if (cAccountNumber<1000) {
                tempAccountNumber="00000000"+cAccountNumber;
            } else if (cAccountNumber<10000) {
                tempAccountNumber="0000000"+cAccountNumber;
            } else if (cAccountNumber<100000) {
                tempAccountNumber="000000"+cAccountNumber;
            } else if (cAccountNumber<1000000) {
                tempAccountNumber="00000"+cAccountNumber;
            } else if (cAccountNumber<10000000) {
                tempAccountNumber="0000"+cAccountNumber;
            } else if (cAccountNumber<100000000) {
                tempAccountNumber="000"+cAccountNumber;
            } else if (cAccountNumber<1000000000) {
                tempAccountNumber="00"+cAccountNumber;
            } else if (cAccountNumber<10E9) {
                tempAccountNumber="0"+cAccountNumber;
            }else {
                tempAccountNumber=String.valueOf(cAccountNumber);
            }
            while (i<accountNumberAlreadyUse.size() && !flag){
                if (tempAccountNumber.equals(accountNumberAlreadyUse.get(i))){
                    flag=true;
                }
                i++;
            }
            if (!flag){
                check=true;
            }

        }while (!check);
        accountNumberAlreadyUse.add(tempAccountNumber);
        this.accountNumber = tempAccountNumber;
        this.agencyCode=agencyCode;
        this.client = client;
        this.balance = balance;
        this.overdraft = overdraft;
    }
    public Account(){

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isOverdraft() {
        return overdraft;
    }

    public void setOverdraft(boolean overdraft) {
        this.overdraft = overdraft;
    }

    public double getFees() {
        return fees;
    }

    public abstract void feesCalculator();

    @Override
    public String toString() {
        String sOverdraft;
        if (overdraft){
            sOverdraft = "autorisé";
        }else {
            sOverdraft = "non-autorisé";
        }
        return " Numéro de compte: " + accountNumber + ", Code agence: " + agencyCode + ", Client: " + client +
                ", Solde: " + balance + ", Découvert: " + sOverdraft + ", Frais/an: " + Math.round(fees*100)/100 + " €";
    }
}
