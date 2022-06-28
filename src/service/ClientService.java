package service;

import beans.Account;
import beans.Client;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientService {
    static Scanner sc = new Scanner(System.in);
    public Client addClient(){
        String lastname, firstname, birthdate, mail;
        System.out.println("Saisissez un nom: ");
        lastname = sc.nextLine();
        System.out.println("Saisissez un prénom: ");
        firstname = sc.nextLine();
        System.out.println("Saisissez la date de naissance(jj/mm/aaaa)");
        birthdate = sc.nextLine();
        System.out.println("Saisissez le mail: ");
        mail = sc.nextLine();
        return new Client(lastname,firstname,birthdate,mail);
    }
    public void findClientByName(ArrayList<Client>clients){
        String name;
        int i=0;
        boolean flag=false;
        System.out.println("Saisissez le nom");
        name = sc.nextLine();
        do{
            if (name.equals(clients.get(i).getLastname())){
                System.out.println(clients.get(i));
                flag = true;
            }
            i++;
        }while (i<clients.size() && !flag);
    }
    public void findClientByAccountNumber(ArrayList<Account>accounts){
        String accountNumber;
        int i=0;
        boolean flag=false;
        System.out.println("Saisissez le numéro de compte: ");
        accountNumber = sc.nextLine();
        do{
            if(accountNumber.equals(accounts.get(i).getAccountNumber())){
                System.out.println(accounts.get(i).getClient());
                flag = true;
            }
            i++;
        } while (i<accounts.size() && !flag);
    }
    public void findClientById(ArrayList<Client>clients){
        String id;
        int i=0;
        boolean flag=false;
        System.out.println("Saisissez l'id");
        id=sc.nextLine();
        do {
            if (id.equals(clients.get(i).getClientId())){
                System.out.println(clients.get(i));
                flag = true;
            }
            i++;
        }while (i<clients.size() && !flag);
    }
//    public void printClientInformation(ArrayList<Client>clients, ArrayList<Account>accounts){
//        FileWriter writer = new FileWriter("FicheClient.csv");
//
//    }
}
