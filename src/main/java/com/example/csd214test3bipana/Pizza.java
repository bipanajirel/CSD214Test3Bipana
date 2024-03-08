package com.example.csd214test3bipana;

public class Pizza {
    private int Id;
    private String CustomerName;
    private String MobileNumber;
    private String PizzaSize;
    private int NumberOfToppings;
    private double TotalBill;


    public Pizza(int Id, String CustomerName, String MobileNumber, String PizzaSize, int NumberOfToppings, double TotalBill) {
        this.Id = Id;
        this.CustomerName = CustomerName;
        this.MobileNumber = MobileNumber;
        this.PizzaSize = PizzaSize;
        this.NumberOfToppings = NumberOfToppings;
        this.TotalBill = TotalBill;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getPizzaSize() {
        return PizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        PizzaSize = pizzaSize;
    }

    public int getNumberOfToppings() {
        return NumberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        NumberOfToppings = numberOfToppings;
    }

    public double getTotalBill() {
        return TotalBill;
    }

    public void setTotalBill(double totalBill) {
        TotalBill = totalBill;
    }

}


