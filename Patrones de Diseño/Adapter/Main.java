package Adapter;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(10000);

        AdapterATM adapterATM = new AdapterATM(atm);

        Customer customer = new Customer(5, 10, 15, 20);

        double atmDepositAmount = atm.deposit(5, 10, 15, 20);
        System.out.println("Saldo del ATM actualizado: $" + atmDepositAmount);

        double adapterATMDepositAmount = adapterATM.deposit(5, 10, 15, 20);
        System.out.println("Saldo del AdapterATM actualizado: $" + adapterATMDepositAmount);

        customer.deposit(atm);
        customer.deposit(adapterATM);
    }
}
