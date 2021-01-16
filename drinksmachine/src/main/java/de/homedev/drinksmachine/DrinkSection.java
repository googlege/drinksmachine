package de.homedev.drinksmachine;

import de.homedev.drinksmachine.exception.DrinkSoldOutException;
import de.homedev.drinksmachine.exception.DrinksMachineException;

public class DrinkSection extends AbstractSection {
    private final int id;
    private final String name;
    private int priceInCent;

    public DrinkSection(final int id, final String name, int priceInCent) {
        super();
        this.id = id;
        this.name = name;
        this.priceInCent = priceInCent;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriceInCent() {
        return priceInCent;
    }

    public void setPriceInCent(int priceInCent) {
        this.priceInCent = priceInCent;
    }

    public int take() throws DrinksMachineException {
        if (quantity <= 0) {
            throw new DrinkSoldOutException(id, name);
        }
        return --quantity;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", price=" + priceInCent + ", quantity=" + quantity;
    }

}
