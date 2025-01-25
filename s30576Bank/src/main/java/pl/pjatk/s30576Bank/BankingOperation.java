package pl.pjatk.s30576Bank;

import java.time.temporal.ChronoUnit;

public class BankingOperation {
    private int id;
    private double price;
    private String operationName;

    public BankingOperation(int id, double price, String operationName) {
        this.id = id;
        this.price = price;
        this.operationName = operationName;
    }

//    public double calculatePrice(Customer customer) {
//        long days = ChronoUnit.DAYS.between(startDate, endDate);
//        return days * car.getStandard().getValue();
//    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getOperationName() {
        return operationName;
    }

//    @Override
//    public String toString() {
//        return "rental: " +
//                "firstName=" + firstName +
//                ", lastName=" + lastName +
//                ", startDate=" + startDate +
//                ", endDate=" + endDate +
//                ", " + car + '\n';
//    }
}