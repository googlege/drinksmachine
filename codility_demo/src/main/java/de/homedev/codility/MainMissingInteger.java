package de.homedev.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * https://app.codility.com/demo/take-sample-test/
 * 
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
*
*/

public class MainMissingInteger {

  public int solution(int[] A) {
    // List<Integer> targetList = Arrays.stream(A).boxed().collect(Collectors.toList());
    List<Integer> targetList = new ArrayList<>(A.length);
    for (int i : A) {
      targetList.add(i);
    }
    Collections.sort(targetList);
    if ((targetList.get(targetList.size() - 1) < 1) || (targetList.get(0) > 1)) {
      return 1;
    }
    Iterator<Integer> it = targetList.iterator();
    int first = it.next();
    int previousPositive = first > 0 ? first : 0;
    while (it.hasNext()) {
      int current = it.next();
      if (current > 0) {
        if ((current > 1) && (previousPositive < 1)) {
          return 1;
        }
        if (current - previousPositive > 1) {
          return previousPositive + 1;
        }
        previousPositive = current;
      }
    }
    return previousPositive + 1;
  }

  public static void main(final String[] args) {

  }
}