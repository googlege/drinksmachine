package de.homedev.drinksmachine;

import de.homedev.drinksmachine.exception.DrinksMachineException;

public interface DrinksmachineInterface {

    public DrinkAndChange buy(int drinkId, Integer... coins) throws DrinksMachineException;

    public String printStatus();

    public int chargeDrinkSection(int id, int chargeQuantity, int newPrice) throws DrinksMachineException;

    public int chargeCoinSection(int coinInCent, int chargeQuantity) throws DrinksMachineException;

    public void removeAllDrinks();

    public void removeAllCoins();

}
