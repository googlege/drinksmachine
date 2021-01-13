package de.homedev.drinksmachine.test;

import org.junit.Test;

import de.homedev.drinksmachine.Drinksmachine;
import de.homedev.drinksmachine.exception.CanNotFindEnoughChangeMoneyException;
import de.homedev.drinksmachine.exception.DrinkSoldOutException;
import de.homedev.drinksmachine.exception.DrinksMachineException;
import de.homedev.drinksmachine.exception.NotEnoughMoneyForDrink;
import de.homedev.drinksmachine.exception.UnsupportedCoinException;
import de.homedev.drinksmachine.exception.WrongDrinkIdException;

public class DrinksmachineByingWithErrorTest {

    @Test(expected = CanNotFindEnoughChangeMoneyException.class)
    public void testCanNotFindEnoughChangeMoney1() throws DrinksMachineException {
        // given
        Drinksmachine drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 0);
        drinksmachine.chargeCoinSection(100, 0);
        drinksmachine.chargeCoinSection(50, 0);
        drinksmachine.chargeCoinSection(20, 0);
        drinksmachine.chargeCoinSection(10, 0);
        // charge with drinks
        drinksmachine.chargeDrinkSection(1, 1, 80);
        drinksmachine.chargeDrinkSection(2, 1, 90);
        drinksmachine.chargeDrinkSection(3, 1, 110);
        drinksmachine.chargeDrinkSection(4, 1, 120);
        drinksmachine.chargeDrinkSection(5, 1, 130);
        drinksmachine.chargeDrinkSection(6, 1, 140);
        drinksmachine.chargeDrinkSection(7, 1, 150);
        drinksmachine.chargeDrinkSection(8, 1, 160);
        drinksmachine.chargeDrinkSection(9, 1, 170);
        drinksmachine.chargeDrinkSection(10, 1, 180);

        // when buying drink with id=4 with coins of 200;
        drinksmachine.buy(4, 200);
    }

    @Test(expected = CanNotFindEnoughChangeMoneyException.class)
    public void testCanNotFindEnoughChangeMoney2() throws DrinksMachineException {
        // given
        Drinksmachine drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 2);
        drinksmachine.chargeCoinSection(100, 2);
        drinksmachine.chargeCoinSection(50, 2);
        drinksmachine.chargeCoinSection(20, 2);
        drinksmachine.chargeCoinSection(10, 0);
        // charge with drinks
        drinksmachine.chargeDrinkSection(1, 1, 80);
        drinksmachine.chargeDrinkSection(2, 1, 90);
        drinksmachine.chargeDrinkSection(3, 1, 110);
        drinksmachine.chargeDrinkSection(4, 1, 120);
        drinksmachine.chargeDrinkSection(5, 1, 130);
        drinksmachine.chargeDrinkSection(6, 1, 140);
        drinksmachine.chargeDrinkSection(7, 1, 150);
        drinksmachine.chargeDrinkSection(8, 1, 160);
        drinksmachine.chargeDrinkSection(9, 1, 170);
        drinksmachine.chargeDrinkSection(10, 1, 180);

        // when buying drink with id=4 with coins of 200;
        drinksmachine.buy(4, 200);
    }

    @Test(expected = NotEnoughMoneyForDrink.class)
    public void testNotEnoughMoneyForDrink() throws DrinksMachineException {
        // given
        Drinksmachine drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 0);
        drinksmachine.chargeCoinSection(100, 0);
        drinksmachine.chargeCoinSection(50, 0);
        drinksmachine.chargeCoinSection(20, 0);
        drinksmachine.chargeCoinSection(10, 20);
        // charge with drinks
        drinksmachine.chargeDrinkSection(1, 1, 80);
        drinksmachine.chargeDrinkSection(2, 1, 90);
        drinksmachine.chargeDrinkSection(3, 1, 110);
        drinksmachine.chargeDrinkSection(4, 1, 120);
        drinksmachine.chargeDrinkSection(5, 1, 130);
        drinksmachine.chargeDrinkSection(6, 1, 140);
        drinksmachine.chargeDrinkSection(7, 1, 150);
        drinksmachine.chargeDrinkSection(8, 1, 160);
        drinksmachine.chargeDrinkSection(9, 1, 170);
        drinksmachine.chargeDrinkSection(10, 1, 180);

        // when buying drink with id=4 with coins of 100;
        drinksmachine.buy(4, 100);
    }

    @Test(expected = WrongDrinkIdException.class)
    public void testWrongDrinkIdException() throws DrinksMachineException {
        // given
        Drinksmachine drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 10);
        drinksmachine.chargeCoinSection(100, 10);
        drinksmachine.chargeCoinSection(50, 10);
        drinksmachine.chargeCoinSection(20, 10);
        drinksmachine.chargeCoinSection(10, 20);
        // charge with drinks
        drinksmachine.chargeDrinkSection(1, 1, 80);
        drinksmachine.chargeDrinkSection(2, 1, 90);
        drinksmachine.chargeDrinkSection(3, 1, 110);
        drinksmachine.chargeDrinkSection(4, 1, 120);
        drinksmachine.chargeDrinkSection(5, 1, 130);
        drinksmachine.chargeDrinkSection(6, 1, 140);
        drinksmachine.chargeDrinkSection(7, 1, 150);
        drinksmachine.chargeDrinkSection(8, 1, 160);
        drinksmachine.chargeDrinkSection(9, 1, 170);
        drinksmachine.chargeDrinkSection(10, 1, 180);

        // when buying drink with id=40 with coins of 100;
        drinksmachine.buy(40, 200);
    }

    @Test(expected = UnsupportedCoinException.class)
    public void testUnsupportedCoinException() throws DrinksMachineException {
        // given
        Drinksmachine drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 10);
        drinksmachine.chargeCoinSection(100, 10);
        drinksmachine.chargeCoinSection(50, 10);
        drinksmachine.chargeCoinSection(20, 10);
        drinksmachine.chargeCoinSection(10, 20);
        // charge with drinks
        drinksmachine.chargeDrinkSection(1, 1, 80);
        drinksmachine.chargeDrinkSection(2, 1, 90);
        drinksmachine.chargeDrinkSection(3, 1, 110);
        drinksmachine.chargeDrinkSection(4, 1, 120);
        drinksmachine.chargeDrinkSection(5, 1, 130);
        drinksmachine.chargeDrinkSection(6, 1, 140);
        drinksmachine.chargeDrinkSection(7, 1, 150);
        drinksmachine.chargeDrinkSection(8, 1, 160);
        drinksmachine.chargeDrinkSection(9, 1, 170);
        drinksmachine.chargeDrinkSection(10, 1, 180);

        // when buying drink with id=4 with coins of 100, 30;
        drinksmachine.buy(4, 100, 30);
    }

    @Test(expected = DrinkSoldOutException.class)
    public void testDrinkSoldOutException() throws DrinksMachineException {
        // given
        Drinksmachine drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 10);
        drinksmachine.chargeCoinSection(100, 10);
        drinksmachine.chargeCoinSection(50, 10);
        drinksmachine.chargeCoinSection(20, 10);
        drinksmachine.chargeCoinSection(10, 20);
        // charge with drinks
        drinksmachine.chargeDrinkSection(1, 1, 80);
        drinksmachine.chargeDrinkSection(2, 1, 90);
        drinksmachine.chargeDrinkSection(3, 1, 110);
        drinksmachine.chargeDrinkSection(4, 0, 120);
        drinksmachine.chargeDrinkSection(5, 1, 130);
        drinksmachine.chargeDrinkSection(6, 1, 140);
        drinksmachine.chargeDrinkSection(7, 1, 150);
        drinksmachine.chargeDrinkSection(8, 1, 160);
        drinksmachine.chargeDrinkSection(9, 1, 170);
        drinksmachine.chargeDrinkSection(10, 1, 180);

        // when buying drink with id=4 with coins of 200;
        drinksmachine.buy(4, 200);
    }

}
