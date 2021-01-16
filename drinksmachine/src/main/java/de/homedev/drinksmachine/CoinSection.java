package de.homedev.drinksmachine;

import de.homedev.drinksmachine.exception.CoinSectionIsEmptyException;
import de.homedev.drinksmachine.exception.DrinksMachineException;

public class CoinSection extends AbstractSection {
    private final int coinInCent;

    public CoinSection(int coinInCent) {
        super();
        this.coinInCent = coinInCent;
    }

    public int getCoinInCent() {
        return coinInCent;
    }

    public int take() throws DrinksMachineException{
        if (quantity <= 0) {
            throw new CoinSectionIsEmptyException(coinInCent);
        }
        return --quantity;
    }

    @Override
    public String toString() {
        return "coinInCent=" + coinInCent + ", quantity=" + quantity;
    }

}
