package de.homedev.drinksmachine.exception;

public class UnsupportedCoinException extends DrinksMachineException {
    private static final long serialVersionUID = 1L;

    public UnsupportedCoinException(int coinInCent) {
        super(coinInCent + " cent coin is unsupported");
    }
}