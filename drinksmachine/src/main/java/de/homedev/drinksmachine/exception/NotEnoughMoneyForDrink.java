package de.homedev.drinksmachine.exception;

public class NotEnoughMoneyForDrink extends DrinksMachineException {
    private static final long serialVersionUID = 1L;

    public NotEnoughMoneyForDrink(int sum, int priceInCent) {
        super("Not enough money get " + sum + ". Drink price " + priceInCent);
    }

}
