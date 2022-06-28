package beans;

import Interface.BasicFees;

public class CurrentAccount extends Account implements BasicFees {
    public CurrentAccount(String agencyCode, Client client, double balance, boolean overdraft) {
        super(agencyCode,client, balance, overdraft);
    }

    @Override
    public void feesCalculator() {
        fees=basicFees;
    }

    public CurrentAccount() {
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
