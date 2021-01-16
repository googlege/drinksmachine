package de.homedev.drinksmachine.exception;

public class CanNotFindEnoughChangeMoneyException extends DrinksMachineException {
    private static final long serialVersionUID = 1L;

    public CanNotFindEnoughChangeMoneyException() {
        super("Can Not Find Enough Change Money.");
    }
}
