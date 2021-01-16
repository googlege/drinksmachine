package de.homedev.drinksmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.homedev.drinksmachine.exception.CanNotFindEnoughChangeMoneyException;
import de.homedev.drinksmachine.exception.DrinksMachineException;
import de.homedev.drinksmachine.exception.NotEnoughMoneyForDrink;
import de.homedev.drinksmachine.exception.UnsupportedCoinException;
import de.homedev.drinksmachine.exception.WrongDrinkIdException;

public final class Drinksmachine implements DrinksmachineInterface {
    // drinks machine structure can't be dynamically modified by working (and we better make the same in Java)
    private CoinSection[] coinSections = new CoinSection[5];
    private DrinkSection[] drinkSections = new DrinkSection[10];

    public Drinksmachine() {
        coinSections[0] = new CoinSection(200);
        coinSections[1] = new CoinSection(100);
        coinSections[2] = new CoinSection(50);
        coinSections[3] = new CoinSection(20);
        coinSections[4] = new CoinSection(10);

        drinkSections[0] = new DrinkSection(1, "Drink 1 Price 80", 80);
        drinkSections[1] = new DrinkSection(2, "Drink 2 Price 90", 90);
        drinkSections[2] = new DrinkSection(3, "Drink 3 Price 110", 110);
        drinkSections[3] = new DrinkSection(4, "Drink 4 Price 120", 120);
        drinkSections[4] = new DrinkSection(5, "Drink 5 Price 130", 130);
        drinkSections[5] = new DrinkSection(6, "Drink 6 Price 140", 140);
        drinkSections[6] = new DrinkSection(7, "Drink 7 Price 150", 150);
        drinkSections[7] = new DrinkSection(8, "Drink 8 Price 160", 160);
        drinkSections[8] = new DrinkSection(9, "Drink 9 Price 170", 170);
        drinkSections[9] = new DrinkSection(10, "Drink 10 Price 180", 180);
    }

    public CoinSection getCoinSection(int coinInCent) throws DrinksMachineException {
        switch (coinInCent) {
        case 10:
            return coinSections[4];
        case 20:
            return coinSections[3];
        case 50:
            return coinSections[2];
        case 100:
            return coinSections[1];
        case 200:
            return coinSections[0];
        }
        throw new UnsupportedCoinException(coinInCent);
    }

    /**
     * 
     * @param drinkId
     *            - drink id. We developed drink machine and implemented drinkId as array index + 1.
     * @return DrinkSection
     */
    public DrinkSection getDrinkSection(int drinkId) throws DrinksMachineException {
        if (drinkId >= 1 && drinkId <= 10) {
            return drinkSections[--drinkId];
        }
        throw new WrongDrinkIdException(drinkId);
    }

    private void validateCoin(int coin) throws DrinksMachineException {
        if (coin != 10 && coin != 20 && coin != 50 && coin != 100 && coin != 200) {
            throw new UnsupportedCoinException(coin);
        }
    }

    private void addCoinsToCointSections(List<Integer> coins) throws DrinksMachineException {
        for (int coint : coins) {
            getCoinSection(coint).put();
        }
    }

    private void addCoinsToCointSections(Integer[] coins) throws DrinksMachineException {
        addCoinsToCointSections(Arrays.asList(coins));
    }

    @Override
    public DrinkAndChange buy(int drinkId, Integer... coins) throws DrinksMachineException {
        DrinkSection drinkSection = getDrinkSection(drinkId);
        int sum = 0;
        for (int coin : coins) {
            validateCoin(coin);
            sum = sum + coin;
        }
        if (drinkSection.getPriceInCent() > sum) {
            throw new NotEnoughMoneyForDrink(sum, drinkSection.getPriceInCent());
        }
        int difference = sum - drinkSection.getPriceInCent();
        if (difference == 0) {
            drinkSection.take();
            addCoinsToCointSections(coins);
            return new DrinkAndChange(drinkSection.getId(), drinkSection.getName(), drinkSection.getPriceInCent(), new Integer[0]);
        }
        List<Integer> change = new ArrayList<Integer>();

        // First check what we can get back from the given money
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(coins));
        Collections.sort(list);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer coin = it.next();
            if (difference - coin >= 0) {
                difference = difference - coin;
                change.add(coin);
                it.remove();
            } else {
                break;
            }
        }
        if (difference == 0) {
            drinkSection.take();
            addCoinsToCointSections(list);
            return new DrinkAndChange(drinkSection.getId(), drinkSection.getName(), drinkSection.getPriceInCent(), change.toArray(new Integer[change.size()]));
        }

        // Now we have to look coins inside drink machine
        int tmpDifferenz;
        for (CoinSection coinSection : coinSections) {
            while (!coinSection.isEmpty() && (tmpDifferenz = difference - coinSection.getCoinInCent()) >= 0) {
                coinSection.take();
                difference = tmpDifferenz;
                change.add(coinSection.getCoinInCent());
            }
            if (difference == 0) {
                drinkSection.take();
                addCoinsToCointSections(list);
                return new DrinkAndChange(drinkSection.getId(), drinkSection.getName(), drinkSection.getPriceInCent(), change.toArray(new Integer[change.size()]));
            }
        }
        throw new CanNotFindEnoughChangeMoneyException();
    }

    @Override
    public String printStatus() {
        StringBuilder sb = new StringBuilder(2000);
        String lineSeparator = "\r\n";
        sb.append("Money").append(lineSeparator);
        for (CoinSection coinSection : coinSections) {
            sb.append(coinSection.toString()).append(lineSeparator);
        }
        sb.append(lineSeparator).append("Drinks").append(lineSeparator);
        for (DrinkSection drinkSection : drinkSections) {
            sb.append(drinkSection.toString()).append(lineSeparator);
        }
        return sb.toString();
    }

    @Override
    public int chargeDrinkSection(int id, int chargeQuantity, int newPrice) throws DrinksMachineException {
        DrinkSection drinkSection = getDrinkSection(id);
        drinkSection.setPriceInCent(newPrice);
        drinkSection.charge(chargeQuantity);
        return drinkSection.getQuantity();
    }

    @Override
    public int chargeCoinSection(int coinInCent, int chargeQuantity) throws DrinksMachineException {
        CoinSection coinSection = this.getCoinSection(coinInCent);
        coinSection.charge(chargeQuantity);
        return coinSection.getQuantity();
    }

    @Override
    public void removeAllDrinks() {
        for (DrinkSection drinkSection : drinkSections) {
            drinkSection.clean();
        }
    }

    @Override
    public void removeAllCoins() {
        for (CoinSection coinSection : coinSections) {
            coinSection.clean();
        }
    }

}
