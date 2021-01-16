package de.homedev.drinksmachine;

import java.util.Arrays;

public class DrinkAndChange {
    private final Integer drinkId;
    private final String drinkName;
    private final Integer drinkPriceInCent;
    private final Integer[] change;

    public DrinkAndChange(int drinkId, String drinkName, Integer drinkPriceInCent, Integer[] change) {
        super();
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkPriceInCent = drinkPriceInCent;
        this.change = change;
    }

    public Integer getDrinkId() {
        return drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public Integer getDrinkPriceInCent() {
        return drinkPriceInCent;
    }

    public Integer[] getChange() {
        return change;
    }

    @Override
    public String toString() {
        return "DrinkAndChange [drinkId=" + drinkId + ", drinkName=" + drinkName + ", drinkPriceInCent=" + drinkPriceInCent + ", change=" + Arrays.toString(change) + "]";
    }

}
