package beans;

import Interface.BasicFees;

public class SavingsAccount extends Account implements BasicFees {
    public SavingsAccount(String agencyCode, Client client, double balance, boolean overdraft) {
        super(agencyCode, client, balance, overdraft);
    }
    public SavingsAccount (){
        super();
    }

    @Override
    public void feesCalculator() {
        fees=basicFees+balance*0.1;
    }
}
