package service;

import beans.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManagement {
    static Scanner sc = new Scanner(System.in);
    ArrayList<Agency> agencies = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Account> accounts = new ArrayList<>();
    Menu menu = new Menu();
    AgencyService agencyService = new AgencyService();
    ClientService clientService = new ClientService();
    AccountService accountService = new AccountService();

    public void homeMenuManagement() {
        int choice;
        do {
            menu.homeMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    agencies.add(agencyService.addAgency());
                    break;
                case 2:
                    clients.add(clientService.addClient());
                    break;
                case 3:
                    accountChoiceManagement();
                    break;
                case 4:
                    accountService.findAccount(accounts);
                    break;
                case 5:
                    menuFindClientManagement();
                    break;
                case 6:
                    accountService.findAccountOfClient(accounts,clients);
                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Fin du programme");
                    break;
                default:
                    System.out.println("Veuillez entrer un des chiffres proposer.");
            }
        } while (choice != 8);

    }
    public void accountChoiceManagement(){
        String idClient, agencyCode;
        int i, j, choice, nbAccount;
        boolean flag, check=false;
        agencyCode=agencyService.agencySelection(agencies);
        for (Client client : clients) {
            System.out.println(client);
        }
        System.out.println("Saisissez l'id du client: ");
        idClient = sc.nextLine();
        i = 0;
        j = 0;
        flag = false;
        while (i < clients.size() && !flag) {
            if (clients.get(i).getClientId().equals(idClient)) {
                flag = true;
                nbAccount = 0;
                while (nbAccount<3 && j < accounts.size()){
                    if (accounts.get(j).getClient().getClientId().equals(clients.get(i).getClientId())){
                        nbAccount++;
                        System.out.println(nbAccount);
                    }
                    j++;
                }
                if (nbAccount==3){
                    System.out.println("Le client possède le nombre maximal de compte");
                }else {
                    do {
                        menu.accountChoice();
                        choice = sc.nextInt();
                        sc.nextLine();
                        if (choice > 0 && choice < 5) {
                            check = true;
                        }
                        switch (choice) {
                            case 1:
                                accounts.add(accountService.addAccount(agencyCode, clients.get(i), new CurrentAccount()));
                                break;
                            case 2:
                                accounts.add(accountService.addAccount(agencyCode, clients.get(i), new SavingsAccount()));
                                break;
                            case 3:
                                accounts.add(accountService.addAccount(agencyCode, clients.get(i), new HomeSavings()));
                                break;
                            case 4:
                                System.out.println("Retour au menu");
                                break;
                            default:
                                System.out.println("Veuillez entrer l'un des chiffres proposer");
                        }
                    } while (!check);
                    accounts.get(accounts.size()-1).feesCalculator();
                }
            }
            i++;
        }
    }
    public void menuFindClientManagement(){
        int choice;
        boolean check=false;
        for(Client client:clients){
            System.out.println(client);
        }
        do {
            menu.findClientMenu();
            choice = sc.nextInt();
            sc.nextLine();
            if (choice > 0 && choice < 5) {
                check = true;
            }
            switch (choice) {
                case 1:
                    clientService.findClientByName(clients);
                    break;
                case 2:
                    clientService.findClientByAccountNumber(accounts);
                    break;
                case 3:
                    clientService.findClientById(clients);
                    break;
                case 4:
                    System.out.println("Retour au menu");
                    break;
                default:
                    System.out.println("Veuillez entrer l'un des chiffres proposer");
            }
        } while (!check);
    }
}
