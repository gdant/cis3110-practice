/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.exit;
import java.text.DecimalFormat;
import java.util.*;

public class PizzaOrder {

    private String drinks;
    private String pizza;
    private double price;
    private String customerName;
    private String phoneNumber = null;
    private int numChoices;
    private int numDrink;
    int lastIndex;
    int count;
    private String drinksOutput;
    private String pizzaOutput;

    public PizzaOrder() {
        this.drinks = "";
        this.pizza = "";
        this.numChoices = 0;
        this.numDrink = 0;
        this.drinksOutput = "";
        this.pizzaOutput = "";
    }

    public void takeOrder() {
        int choicePizza;
        int choiceDrink;
        int choice;
        double pizzaPrices[] = {14.00, 12.00, 12.00, 10.00, 10.00, 8.00, 10.00, 8.00};
        String names[] = {"Hawaiian Pizza Extra Large", "Hawaiian Pizza Regular", "Buffalo Pizza Extra Large", "Buffalo Pizza Regular", "Cheese Pizza Extra Large", "Cheese Pizza Regular", "Veggie Pizza Extra Large", "Veggie Pizza Regular"};
        String drinkNames[] = {"Ice Tea", "Soft Drinks", "Bottled Water", "Espresso", "Latte", "Cappuccino", "Cold Brew"};
        double drinkPrices[] = {1.50, 2.50, 1.50, 4.50, 4.50, 6.00, 4.00};

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("======Welcome to Pizza Ordering System======");
            System.out.println("===Select Customer Selection or Exit [1, 2]===");
            System.out.println("1. Customer Selection ");
            System.out.println("2. Exit ");

            choice = sc.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Error! Number must be 1 or 2. ");
            }
            if (choice == 2) {
                exit(0);
            } else {
                pizza = names[choice - 1];
                price += pizzaPrices[choice - 1];
                break;
            }

        }

        while (true) {
            System.out.println("=== Select Pizza: ===");
            System.out.println("1 Hawaiian  Pizza Extra Large $14.00");
            System.out.println("2 Hawaiian  Pizza Regular     $12.00");
            System.out.println("3 Buffalo   Pizza Extra Large $12.00");
            System.out.println("4 Buffalo   Pizza Regular     $10.00");
            System.out.println("5 Cheese    Pizza Extra Large $10.00");
            System.out.println("6 Cheese    Pizza Regular     $8.00");
            System.out.println("7 Veggie    Pizza Extra Large $10.00");
            System.out.println("8 Veggie    Pizza Regular     $8.00");
            System.out.println("9 Quit Pizza selection");
            System.out.println("Select Pizza: [1, 9]: ");
            choicePizza = sc.nextInt();
            if (choicePizza < 1 || choicePizza > 9) {
                System.out.println("Error! Number must be between 1 and 9");
            } else if (choicePizza >= 1 && choicePizza <= 8) {
                pizza += names[choicePizza - 1];
               
                price += pizzaPrices[choicePizza - 1];

            } else if (choicePizza == 9) {
                break;
            } 
        }
        for (int i = 0; i < names.length; i++) {
            lastIndex = 0;
            count = 0;
            while (lastIndex != -1) {
                lastIndex = pizza.indexOf(names[i], lastIndex);
                if (lastIndex != -1) {
                    count++;
                    lastIndex += names[i].length();
                }
            }
            if (count > 0) {
                pizzaOutput += names[i] + "(" + count + "); ";
            }
        }
        while (true) {
            System.out.println("=== Select Drinks: === ");
            System.out.println("1 Ice Tea        $1.50");
            System.out.println("2 Soft Drinks    $2.00");
            System.out.println("3 Bottled Water  $1.50");
            System.out.println("4 Espresso       $4.50");
            System.out.println("5 Latte          $4.50");
            System.out.println("6 Cappuccino     $6.00");
            System.out.println("7 Cold Brew      $4.00");
            System.out.println("8 Quit Drinks selection");
            System.out.print("Select Drinks: [1, 8]: ");
            choiceDrink = sc.nextInt();
            if (choiceDrink < 1 || choiceDrink > 8) {
                System.out.println("Error! Number must be between 1 and 8");
            } else if (choiceDrink >= 1 && choiceDrink <= 7) {
                
                drinks += drinkNames[choiceDrink - 1];
                price += drinkPrices[choiceDrink - 1];
            } else {
                break;
            }
        }
        for (int i = 0; i < drinkNames.length; i++) {
            lastIndex = 0;
            count = 0;
            while (lastIndex != -1) {
                lastIndex = drinks.indexOf(drinkNames[i], lastIndex);
                if (lastIndex != -1) {
                    count++;
                    lastIndex += drinkNames[i].length();
                }
            }
            if (count > 0) {
                drinksOutput += drinkNames[i] + "(" + count + "); ";
            }
        }
        
        System.out.println("Enter Name :"+ sc.nextLine());
        customerName = sc.nextLine();

        System.out.println("Enter Phone #");
        phoneNumber = sc.nextLine();
        sc.close();

    }

    public void displayBill() throws IOException {
        DecimalFormat df = new DecimalFormat(".00");
        System.out.println("Customer name: " + customerName + "; Phone: " + phoneNumber);
        System.out.println(pizzaOutput + drinksOutput);
        System.out.println("Total: " + df.format(price));
        try {
            FileWriter fw = new FileWriter("orderreceipt.txt ", true);
            BufferedWriter bw = new BufferedWriter( fw );
            try{
            bw.newLine();
            bw.write("Customer name: " + customerName + "; Phone: " + phoneNumber);
            bw.newLine();
            bw.write(pizzaOutput + drinksOutput);
            bw.newLine();
            bw.write("Total: " + df.format(price));
            bw.flush();
            
        } catch (IOException e) {
            
        }
           fw.close();     
    }
    catch (IOException ioe) {
    }
}
}