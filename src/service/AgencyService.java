package service;

import beans.Agency;

import java.util.ArrayList;
import java.util.Scanner;

public class AgencyService {
    static Scanner sc = new Scanner(System.in);
    public Agency addAgency(){
        String name, address;
        System.out.println("Saisissez le nom de l'agence");
        name = sc.nextLine();
        System.out.println("Saisissez l'adresse de l'agence");
        address = sc.nextLine();
        return new Agency(name,address);
    }
    public String agencySelection(ArrayList<Agency>agencies){
        String agencyCode;
        for(Agency agency:agencies){
            System.out.println(agency);
        }
        System.out.println("Saisissez le code agence de l'agence souhaiter");
        agencyCode=sc.nextLine();
        return agencyCode;
    }
}
