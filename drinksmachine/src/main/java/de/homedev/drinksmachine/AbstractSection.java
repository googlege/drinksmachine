package de.homedev.drinksmachine;

public abstract class AbstractSection {
    int quantity = 0;

    public int put() {
        return ++quantity;
    }

    /**
     * 
     * @param chargeQuantity
     *            - charge quantity (we are working only with algorithm and not with simulated objects. Read readme.txt)
     * @return - objects number after charging
     */
    public int charge(int chargeQuantity) {
        quantity = quantity + chargeQuantity;
        return quantity;
    }

    public void clean() {
        quantity = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isEmpty() {
        return quantity < 1;
    }
}
