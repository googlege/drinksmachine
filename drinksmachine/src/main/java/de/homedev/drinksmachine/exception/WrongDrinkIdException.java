package de.homedev.drinksmachine.exception;

public class WrongDrinkIdException extends DrinksMachineException {
    private static final long serialVersionUID = 1L;

    public WrongDrinkIdException(int drinkId) {
        super("Drink with id " + drinkId + " not exists");
    }

}
