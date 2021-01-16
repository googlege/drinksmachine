package de.homedev.coditity.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.homedev.codility.MainMissingInteger;



public class MissingIntegerTest {

	private MainMissingInteger main;

	@Before
	public void init() {
		main = new MainMissingInteger();
	}

	@Test
	public void test1() {
		int[] A = { 1, 3, 6, 4, 1, 2 };
		Assert.assertEquals(5, main.solution(A));
	}

	@Test
	public void test2() {
		int[] A = { 1, 2, 3 };
		Assert.assertEquals(4, main.solution(A));
	}

	@Test
	public void test3() {
		int[] A = { -1, -3 };
		Assert.assertEquals(1, main.solution(A));
	}

	@Test
	public void test4() {
		int[] A = { 90, 91, 92, 93 };
		Assert.assertEquals(1, main.solution(A));
	}

	@Test
	public void test5() {
		int[] A = { 4, 5, 6, 2 };
		Assert.assertEquals(1, main.solution(A));
	}

}
