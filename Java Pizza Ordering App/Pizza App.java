/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.io.IOException;

public class PizzaApp {

    public static void main(String[] args) throws IOException {
        PizzaOrder co = new PizzaOrder();
        co.takeOrder();
        co.displayBill();

    }

}
