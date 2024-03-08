package com.example.csd214test3bipana;

public class PizzaOrder {
    public enum PizzaSize {
        XL, L, M, S
    }

    private static final double XL_PRICE = 15.00;
    private static final double L_PRICE = 12.00;
    private static final double M_PRICE = 10.00;
    private static final double S_PRICE = 8.00;
    private static final double TOPPING_PRICE = 1.50;
    private static final double HST_RATE = 0.15;

    public static double TotalBill(PizzaSize size, int toppings) {
        double basePrice;
        switch (size) {
            case XL:
                basePrice = XL_PRICE;
                break;
            case L:
                basePrice = L_PRICE;
                break;
            case M:
                basePrice = M_PRICE;
                break;
            case S:
                basePrice = S_PRICE;
                break;
            default:
                throw new IllegalArgumentException("Invalid PizzaSize");
        }

        double toppingsCost = toppings * TOPPING_PRICE;
        double subtotal = basePrice + toppingsCost;
        double hst = subtotal * HST_RATE;
        return subtotal + hst;
    }
}

