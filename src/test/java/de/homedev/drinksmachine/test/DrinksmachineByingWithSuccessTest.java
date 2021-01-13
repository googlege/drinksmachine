package de.homedev.drinksmachine.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.homedev.drinksmachine.DrinkAndChange;
import de.homedev.drinksmachine.Drinksmachine;
import de.homedev.drinksmachine.exception.DrinksMachineException;

public class DrinksmachineByingWithSuccessTest {

    Drinksmachine drinksmachine;

    @Before
    public void init() throws DrinksMachineException {
        drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 10);
        drinksmachine.chargeCoinSection(100, 20);
        drinksmachine.chargeCoinSection(50, 40);
        drinksmachine.chargeCoinSection(20, 100);
        drinksmachine.chargeCoinSection(10, 100);
        // charge with drinks
        drinksmachine.chargeDrinkSection(1, 11, 80);
        drinksmachine.chargeDrinkSection(2, 12, 90);
        drinksmachine.chargeDrinkSection(3, 13, 110);
        drinksmachine.chargeDrinkSection(4, 14, 120);
        drinksmachine.chargeDrinkSection(5, 15, 130);
        drinksmachine.chargeDrinkSection(6, 16, 140);
        drinksmachine.chargeDrinkSection(7, 17, 150);
        drinksmachine.chargeDrinkSection(8, 18, 160);
        drinksmachine.chargeDrinkSection(9, 19, 170);
        drinksmachine.chargeDrinkSection(10, 20, 180);
    }

    @Test
    public void test1SampleInPDFFile() throws DrinksMachineException {
        // given

        // when buying drink with id=4 with coins of 200;
        DrinkAndChange result = drinksmachine.buy(4, 200);

        // then result
        Assert.assertEquals(4, result.getDrinkId().intValue());
        Assert.assertEquals(120, result.getDrinkPriceInCent().intValue());
        Integer[] a = { 50, 20, 10 };
        Assert.assertArrayEquals(a, result.getChange());

        // then drinks
        Assert.assertEquals(13, drinksmachine.getDrinkSection(4).getQuantity());

        // then money
        Assert.assertEquals(11, drinksmachine.getCoinSection(200).getQuantity());
        Assert.assertEquals(20, drinksmachine.getCoinSection(100).getQuantity());
        Assert.assertEquals(39, drinksmachine.getCoinSection(50).getQuantity());
        Assert.assertEquals(99, drinksmachine.getCoinSection(20).getQuantity());
        Assert.assertEquals(99, drinksmachine.getCoinSection(10).getQuantity());
    }

    @Test
    public void test2() throws DrinksMachineException {
        // given
        drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 0);
        drinksmachine.chargeCoinSection(100, 0);
        drinksmachine.chargeCoinSection(50, 1);
        drinksmachine.chargeCoinSection(20, 2);
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

        // when buying drink with id=1 with coin of 2 Euro;
        DrinkAndChange result = drinksmachine.buy(1, 200);

        // then result
        Assert.assertEquals(1, result.getDrinkId().intValue());
        Assert.assertEquals(80, result.getDrinkPriceInCent().intValue());
        Integer[] a = { 50, 20, 20, 10, 10, 10 };
        Assert.assertArrayEquals(a, result.getChange());
        // then drinks
        Assert.assertEquals(0, drinksmachine.getDrinkSection(1).getQuantity());
        // then money
        Assert.assertEquals(1, drinksmachine.getCoinSection(200).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(100).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(50).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(20).getQuantity());
        Assert.assertEquals(17, drinksmachine.getCoinSection(10).getQuantity());

    }

    @Test
    public void test2_1() throws DrinksMachineException {
        // given
        drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 0);
        drinksmachine.chargeCoinSection(100, 0);
        drinksmachine.chargeCoinSection(50, 1);
        drinksmachine.chargeCoinSection(20, 3);
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

        // when buying drink with id=1 with coin of 2 Euro;
        DrinkAndChange result = drinksmachine.buy(1, 200);

        // then result
        Assert.assertEquals(1, result.getDrinkId().intValue());
        Assert.assertEquals(80, result.getDrinkPriceInCent().intValue());
        Integer[] a = { 50, 20, 20, 20, 10 };
        Assert.assertArrayEquals(a, result.getChange());
        // then drinks
        Assert.assertEquals(0, drinksmachine.getDrinkSection(1).getQuantity());
        // then money
        Assert.assertEquals(1, drinksmachine.getCoinSection(200).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(100).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(50).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(20).getQuantity());
        Assert.assertEquals(19, drinksmachine.getCoinSection(10).getQuantity());

    }

    @Test
    public void test3() throws DrinksMachineException {
        // given

        // when buying drink with id=6 with coin of 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10;
        DrinkAndChange result = drinksmachine.buy(6, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

        // then result
        Assert.assertEquals(6, result.getDrinkId().intValue());
        Assert.assertEquals(140, result.getDrinkPriceInCent().intValue());
        Integer[] a = {};
        Assert.assertArrayEquals(a, result.getChange());

        // then drinks
        Assert.assertEquals(15, drinksmachine.getDrinkSection(6).getQuantity());

        // then money
        Assert.assertEquals(10, drinksmachine.getCoinSection(200).getQuantity());
        Assert.assertEquals(20, drinksmachine.getCoinSection(100).getQuantity());
        Assert.assertEquals(40, drinksmachine.getCoinSection(50).getQuantity());
        Assert.assertEquals(100, drinksmachine.getCoinSection(20).getQuantity());
        Assert.assertEquals(114, drinksmachine.getCoinSection(10).getQuantity());
    }

    @Test
    public void test4GetBackOwnMoney() throws DrinksMachineException {
        // given

        // when buying drink with id=5 with coins of 100,20,10,10,10;
        DrinkAndChange result = drinksmachine.buy(5, 100, 20, 10, 10, 10);

        // then result
        Assert.assertEquals(5, result.getDrinkId().intValue());
        Assert.assertEquals(130, result.getDrinkPriceInCent().intValue());
        Integer[] a = { 10, 10 }; // 10, 10 - own money
        Assert.assertArrayEquals(a, result.getChange());

        // then drinks
        Assert.assertEquals(14, drinksmachine.getDrinkSection(5).getQuantity());

        // then money
        Assert.assertEquals(10, drinksmachine.getCoinSection(200).getQuantity());
        Assert.assertEquals(21, drinksmachine.getCoinSection(100).getQuantity());
        Assert.assertEquals(40, drinksmachine.getCoinSection(50).getQuantity());
        Assert.assertEquals(101, drinksmachine.getCoinSection(20).getQuantity());
        Assert.assertEquals(101, drinksmachine.getCoinSection(10).getQuantity());
    }

    @Test
    public void test5GetBackOwnMoney() throws DrinksMachineException {
        // given

        // when buying drink with id=5 with coins of 100, 100, 100;
        DrinkAndChange result = drinksmachine.buy(1, 100, 100, 100);

        // then result
        Assert.assertEquals(1, result.getDrinkId().intValue());
        Assert.assertEquals(80, result.getDrinkPriceInCent().intValue());
        Integer[] a = { 100, 100, 20 };// 100, 100 - own money
        Assert.assertArrayEquals(a, result.getChange());

        // then drinks
        Assert.assertEquals(10, drinksmachine.getDrinkSection(1).getQuantity());

        // then money
        Assert.assertEquals(10, drinksmachine.getCoinSection(200).getQuantity());
        Assert.assertEquals(21, drinksmachine.getCoinSection(100).getQuantity());
        Assert.assertEquals(40, drinksmachine.getCoinSection(50).getQuantity());
        Assert.assertEquals(99, drinksmachine.getCoinSection(20).getQuantity());
        Assert.assertEquals(100, drinksmachine.getCoinSection(10).getQuantity());
    }

    @Test
    public void test6() throws DrinksMachineException {
        // given

        // when buying drink with id=6 with coin of 2 Euro;
        DrinkAndChange result = drinksmachine.buy(6, 200);

        // then result
        Assert.assertEquals(6, result.getDrinkId().intValue());
        Assert.assertEquals(140, result.getDrinkPriceInCent().intValue());
        Integer[] a = { 50, 10 };
        Assert.assertArrayEquals(a, result.getChange());
        // then drinks
        Assert.assertEquals(15, drinksmachine.getDrinkSection(6).getQuantity());
        // then money
        Assert.assertEquals(11, drinksmachine.getCoinSection(200).getQuantity());
        Assert.assertEquals(20, drinksmachine.getCoinSection(100).getQuantity());
        Assert.assertEquals(39, drinksmachine.getCoinSection(50).getQuantity());
        Assert.assertEquals(100, drinksmachine.getCoinSection(20).getQuantity());
        Assert.assertEquals(99, drinksmachine.getCoinSection(10).getQuantity());

    }

    @Test
    public void testRemoveAllFunctions() throws DrinksMachineException {
        // given
        // given
        Drinksmachine drinksmachine = new Drinksmachine();
        // charge with coins
        drinksmachine.chargeCoinSection(200, 10);
        drinksmachine.chargeCoinSection(100, 10);
        drinksmachine.chargeCoinSection(50, 10);
        drinksmachine.chargeCoinSection(20, 10);
        drinksmachine.chargeCoinSection(10, 10);
        // charge with drinks
        drinksmachine.chargeDrinkSection(1, 11, 80);
        drinksmachine.chargeDrinkSection(2, 11, 90);
        drinksmachine.chargeDrinkSection(3, 11, 110);
        drinksmachine.chargeDrinkSection(4, 11, 120);
        drinksmachine.chargeDrinkSection(5, 11, 130);
        drinksmachine.chargeDrinkSection(6, 11, 140);
        drinksmachine.chargeDrinkSection(7, 11, 150);
        drinksmachine.chargeDrinkSection(8, 11, 160);
        drinksmachine.chargeDrinkSection(9, 11, 170);
        drinksmachine.chargeDrinkSection(10, 11, 180);

        // when remove all;
        drinksmachine.removeAllCoins();
        drinksmachine.removeAllDrinks();

        // then result

        // then drinks
        Assert.assertEquals(0, drinksmachine.getDrinkSection(1).getQuantity());
        Assert.assertEquals(0, drinksmachine.getDrinkSection(2).getQuantity());
        Assert.assertEquals(0, drinksmachine.getDrinkSection(3).getQuantity());
        Assert.assertEquals(0, drinksmachine.getDrinkSection(4).getQuantity());
        Assert.assertEquals(0, drinksmachine.getDrinkSection(5).getQuantity());
        Assert.assertEquals(0, drinksmachine.getDrinkSection(6).getQuantity());
        Assert.assertEquals(0, drinksmachine.getDrinkSection(7).getQuantity());
        Assert.assertEquals(0, drinksmachine.getDrinkSection(8).getQuantity());
        Assert.assertEquals(0, drinksmachine.getDrinkSection(9).getQuantity());
        Assert.assertEquals(0, drinksmachine.getDrinkSection(10).getQuantity());

        // then money
        Assert.assertEquals(0, drinksmachine.getCoinSection(200).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(100).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(50).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(20).getQuantity());
        Assert.assertEquals(0, drinksmachine.getCoinSection(10).getQuantity());

    }

}
