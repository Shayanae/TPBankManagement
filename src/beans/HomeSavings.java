package beans;

import Interface.BasicFees;

public class HomeSavings extends Account implements BasicFees {
    public HomeSavings(String agencyCode, Client client, double balance, boolean overdraft) {
        super(agencyCode, client, balance, overdraft);
    }

    public HomeSavings() {
        super();
    }

    @Override
    public void feesCalculator() {
        fees=basicFees+balance*0.025;
    }
}
