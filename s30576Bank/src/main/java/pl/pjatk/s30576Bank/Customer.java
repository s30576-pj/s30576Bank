package pl.pjatk.s30576Bank;

public class Customer {
    private int id;
    private String first_name;
    private String surname;
    private double saldo;

    public Customer(int id, String first_name, String surname, double saldo) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }
}