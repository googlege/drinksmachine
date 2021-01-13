package de.homedev.drinksmachine;

public class ApplicationMain {

    public static void main(String[] args) {
        try {
            DrinksmachineInterface drinksmachine = new Drinksmachine();
            // charge with coins
            drinksmachine.chargeCoinSection(200, 10);
            drinksmachine.chargeCoinSection(100, 20);
            drinksmachine.chargeCoinSection(50, 40);
            drinksmachine.chargeCoinSection(20, 100);
            drinksmachine.chargeCoinSection(10, 100);
            // charge with drinks
            drinksmachine.chargeDrinkSection(1, 11, 80);
            drinksmachine.chargeDrinkSection(2, 12, 90);
            drinksmachine.chargeDrinkSection(3, 13, 110);
            drinksmachine.chargeDrinkSection(4, 14, 120);
            drinksmachine.chargeDrinkSection(5, 15, 130);
            drinksmachine.chargeDrinkSection(6, 16, 140);
            drinksmachine.chargeDrinkSection(7, 17, 150);
            drinksmachine.chargeDrinkSection(8, 18, 160);
            drinksmachine.chargeDrinkSection(9, 19, 170);
            drinksmachine.chargeDrinkSection(10, 20, 180);
            // Print status
            System.out.println(drinksmachine.printStatus());
            // buy drink with id=6;
            DrinkAndChange result = drinksmachine.buy(6, 200);
            System.out.println(result);
            // Print status
            System.out.println(drinksmachine.printStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
