package de.homedev.drinksmachine.exception;

public class CoinSectionIsEmptyException extends DrinksMachineException {
    private static final long serialVersionUID = 1L;

    public CoinSectionIsEmptyException(int coinInCent) {
        super(coinInCent + " coins section is empty");
    }

}
