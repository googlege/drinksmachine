package de.homedev.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Complete the 'countMoves' function below.
 *
 * The function is expected to return a LONG_INTEGER. The function accepts
 * INTEGER_ARRAY numbers as parameter.
 * Increase every value besides single max value till all values are equals. As a result return steps number.
 * 
Sample Array: 3, 1, 2, 3
step: 0 -> 3 1 2 3
step: 1 -> 3 2 3 4 
step: 2 -> 4 3 4 4 
step: 3 -> 4 4 5 5 
step: 4 -> 5 5 5 6 
step: 5 -> 6 6 6 6 
result:5
 * 
 */
public class HackerrankTaskMain {
   public static class Result {
   public static long countMoves(List<Integer> numbers) {
		if (numbers.isEmpty() || numbers.size() == 1) {
			return 0;
		}
		Integer[] list = numbers.toArray(new Integer[numbers.size()]);
		long step = 0;
		while (true) {
			int maxPosition = -1;
			int maxValue = Integer.MIN_VALUE;
			boolean allValuesAreEqual = true;
			for (int i = 0; i < list.length; i++) {
				Integer value = list[i];
				// are all values equal!
				if (i > 0 && value != maxValue) {
					allValuesAreEqual = false;
				}
				// calculate max value position
				if (maxValue < value) {
					maxValue = value;
					maxPosition = i;
				}
			}
			if (allValuesAreEqual) {
				System.out.println("result:"+step);
				return step;
			}
			step++;
			System.out.println("step: " + step);
			// increase before max value
			for (int j = 0; j < maxPosition; j++) {
				list[j] = list[j] + 1;
				System.out.print(list[j]);
				System.out.print(" ");
			}
			System.out.print(list[maxPosition]);
			System.out.print(" ");
			// increase after max value
			for (int j = maxPosition + 1; j < list.length; j++) {
				list[j] = list[j] + 1;
				System.out.print(list[j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("HackerrankAlgorithmTask.txt"));

		int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

		long result = Result.countMoves(numbers);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}