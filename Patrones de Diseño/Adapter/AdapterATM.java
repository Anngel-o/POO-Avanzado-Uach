package Adapter;

public class AdapterATM implements Machine{
    private ATM atm;
    public AdapterATM(ATM atm) {
        this.atm = atm;
    }
    @Override
    public double deposit(int quarters, int dimes, int nickels, int pennies) {
        // Adaptación para llamar al método de depósito en ATM
        return atm.deposit(quarters, dimes, nickels, pennies);
    }
}
