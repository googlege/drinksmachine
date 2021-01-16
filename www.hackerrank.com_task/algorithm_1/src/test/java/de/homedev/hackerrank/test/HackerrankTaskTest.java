package de.homedev.hackerrank.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import de.homedev.hackerrank.HackerrankTaskMain;

public class HackerrankTaskTest {

	@Test
	public void test1() {
       Assert.assertEquals(5, HackerrankTaskMain.Result.countMoves(Arrays.asList(3, 1, 2, 3)));
	}
	
	@Test
	public void test2() {
       Assert.assertEquals(7, HackerrankTaskMain.Result.countMoves(Arrays.asList(3, 4, 6, 6, 3)));
	}

}
