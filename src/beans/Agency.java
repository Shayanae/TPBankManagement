package beans;

import java.util.ArrayList;

public class Agency{
    public static ArrayList<String>agencyCodeAlreadyUse = new ArrayList<>();
    private String agencyCode;
    private String nameAgency;
    private String address;

    public Agency(String nameAgency, String address) {
        int cAgencyCode,i=0;
        String tempAgencyCode;
        boolean check=false, flag=false;
        do {
            cAgencyCode = (int) Math.round(Math.random() * 1000);
            if (cAgencyCode<10){
                tempAgencyCode="00"+cAgencyCode;
            } else if (cAgencyCode<100) {
                tempAgencyCode="0"+cAgencyCode;
            }else {
                tempAgencyCode=String.valueOf(cAgencyCode);
            }
            while (i<agencyCodeAlreadyUse.size()&&!flag){
                if (tempAgencyCode.equals(agencyCodeAlreadyUse.get(i))){
                    flag=true;
                }
                i++;
            }
            if (!flag){
                check=true;
            }
        }while (!check);
        this.agencyCode=tempAgencyCode;
        this.nameAgency = nameAgency;
        this.address = address;
    }
    public Agency(){

    }

    public String getNameAgency() {
        return nameAgency;
    }

    public void setNameAgency(String nameAgency) {
        this.nameAgency = nameAgency;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Code de l'agence: " + agencyCode + ", Nom de l'agence: " + nameAgency + ", Adresse: " + address;
    }
}
