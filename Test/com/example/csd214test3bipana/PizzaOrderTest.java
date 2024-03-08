package com.example.csd214test3bipana;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTest {

    @Test
    void TotalBill() {
        PizzaOrder get= new PizzaOrder();
        assertEquals(get.TotalBill(PizzaOrder.PizzaSize.XL,2));


    }
    private void assertEquals(double v){

    }




}