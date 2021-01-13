package de.homedev.drinksmachine.exception;

public class DrinkSoldOutException extends DrinksMachineException {
    private static final long serialVersionUID = 1L;

    public DrinkSoldOutException(int id, String drinkName) {
        super(drinkName + " with id " + id + " is sold out");
    }

}
