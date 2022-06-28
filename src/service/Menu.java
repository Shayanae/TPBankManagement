package service;

public class Menu {
    public void homeMenu() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                                         *");
        System.out.println("*    1. Créer une agence                                  *");
        System.out.println("*                                                         *");
        System.out.println("*    2. Créer un client                                   *");
        System.out.println("*                                                         *");
        System.out.println("*    3. Créer compte bancaire                             *");
        System.out.println("*                                                         *");
        System.out.println("*    4. Recherche de compte                               *");
        System.out.println("*                                                         *");
        System.out.println("*    5. Recherche de client                               *");
        System.out.println("*                                                         *");
        System.out.println("*    6. Afficher la liste des comptes d'un client         *");
        System.out.println("*                                                         *");
        System.out.println("*    7. Imprimer les infos client                         *");
        System.out.println("*                                                         *");
        System.out.println("*    8. Quitter le programme                              *");
        System.out.println("*                                                         *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
        System.out.println("Saisissez votre choix: ");
    }
    public void accountChoice(){
        System.out.println("Choix du type de compte: ");
        System.out.println();
        System.out.println("* * * * * * * * * * * * * * * * * *");
        System.out.println("*                                 *");
        System.out.println("*    1. Compte courant            *");
        System.out.println("*                                 *");
        System.out.println("*    2. Livret A                  *");
        System.out.println("*                                 *");
        System.out.println("*    3. Plan épargne              *");
        System.out.println("*                                 *");
        System.out.println("*    4. Retour au menu            *");
        System.out.println("*                                 *");
        System.out.println("* * * * * * * * * * * * * * * * * *");
        System.out.println();
        System.out.println("Saisissez votre choix");
    }
    public void findClientMenu(){
        System.out.println("Choix de recherche ");
        System.out.println();
        System.out.println("* * * * * * * * * * * * * * * * * *");
        System.out.println("*                                 *");
        System.out.println("*    1. Par nom                   *");
        System.out.println("*                                 *");
        System.out.println("*    2. Par Numéro de compte      *");
        System.out.println("*                                 *");
        System.out.println("*    3. Par identifiant           *");
        System.out.println("*                                 *");
        System.out.println("*    4. Retour au menu            *");
        System.out.println("*                                 *");
        System.out.println("* * * * * * * * * * * * * * * * * *");
        System.out.println();
        System.out.println("Saisissez votre choix");
    }
}
