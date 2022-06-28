package beans;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
public class Client {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static ArrayList<String> idAlreadyUse = new ArrayList<>();
    private String clientId;
    private String lastname;
    private String firstname;
    private LocalDate birthdate;
    private String mail;

    public Client(String lastname, String firstname, String birthdate, String mail) {
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ", randomClientId="";
        char[] cAlphabet=alphabet.toCharArray();
        char tempL;
        int index, i=0;
        boolean check=false, flag=false;
        do {
            while (randomClientId.length() != 2) {
                index = (int) Math.round(Math.random() * alphabet.length());
                tempL = cAlphabet[index];
                if (tempL != cAlphabet[index]) {
                    randomClientId = randomClientId + cAlphabet[index];
                }
                randomClientId = randomClientId + cAlphabet[index];
            }
            int clientIdNumber;
            clientIdNumber = (int) Math.round(Math.random() * 1000000);
            if (clientIdNumber < 10) {
                randomClientId = randomClientId + "00000" + clientIdNumber;
            } else if (clientIdNumber < 100) {
                randomClientId = randomClientId + "0000" + clientIdNumber;
            } else if (clientIdNumber < 1000) {
                randomClientId = randomClientId + "000" + clientIdNumber;
            } else if (clientIdNumber < 10000) {
                randomClientId = randomClientId + "00" + clientIdNumber;
            } else if (clientIdNumber < 100000) {
                randomClientId = randomClientId + "0" + clientIdNumber;
            } else {
                randomClientId += String.valueOf(clientIdNumber);
            }
            while (i<idAlreadyUse.size() && !flag){
                if (randomClientId.equals(idAlreadyUse.get(i))){
                    flag=true;
                }
                i++;
            }
            if (!flag){
                check=true;
            }
        }while (!check);
        idAlreadyUse.add(randomClientId);
        this.clientId = randomClientId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthdate = LocalDate.parse(birthdate,formatter);
        this.mail = mail;
    }

    public String getClientId() {
        return clientId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = LocalDate.parse(birthdate,formatter);;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "ID du client: " + clientId + ", Nom: " + lastname + ", Prénom: " + firstname +
                ", Date de naissance: " + formatter.format(birthdate) + ", mail: " + mail;
    }
}
