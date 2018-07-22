package com.springboot.exercise.Dictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class TestClass {
	static Map<Integer, Boolean> map = new HashMap<>();

	public static void test() {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int[] brr = Arrays.copyOfRange(arr, 1, 5);
		Arrays.stream(brr).forEach((i) -> System.out.println(i));
	}

	public static void main(String args[]) throws Exception {
		execute();
	}

	public static void execute() {
		// Scanner
		Scanner s = new Scanner(System.in);
		int tcs = Integer.parseInt(s.nextLine());
		TestCase[] testcases = new TestCase[tcs];
		for (int z = 0; z < tcs; z++) {
			int arraySize = Integer.parseInt(s.nextLine());
			Integer[] array = new Integer[arraySize];
			Arrays.stream(s.nextLine().split(" ")).map((str) -> {
				return Integer.parseInt(str);
			}).collect(Collectors.toList()).toArray(array);
			int tasks = Integer.parseInt(s.nextLine());
			Integer[][] taskarray = new Integer[tasks][tasks];
			for (int i = 0; i < tasks; i++) {
				Arrays.stream(s.nextLine().split(" ")).map((str) -> {
					return Integer.parseInt(str);
				}).collect(Collectors.toList()).toArray(taskarray[i]);
			}
			testcases[z] = new TestCase(z, arraySize, array, tasks, taskarray);
		}

		/*
		 * System.out.println("test cases:" + tcs); System.out.println("array size:" +
		 * arraySize); StringBuilder str = new StringBuilder();
		 * Arrays.stream(array).forEach((i) -> str.append(i + " "));
		 * System.out.println("Array:" + str); System.out.println("tasks:" + tasks); for
		 * (int j=0; j<tasks;j++) { System.out.println(taskarray[j][0] + " " +
		 * taskarray[j][1]); }
		 */

		// Write your code here
		long st = System.currentTimeMillis();
		for (TestCase tc : testcases) {
			for (int k = 0; k < tc.tasks; k++) {
				int step = 0;
				int start = tc.taskarray[k][0];
				int end = tc.taskarray[k][1];
				Integer[] subarray = Arrays.copyOfRange(tc.array, start - 1, end);
				boolean[] oldNumbers = markAndGetOldNumbers(subarray);
				int oldnums = getCountofOldNumbers(oldNumbers);
				// System.out.println("oldnums in the range " + start + ":" + end + " = " +
				// oldnums);
				while (oldnums < (oldNumbers.length - oldnums)) {
					for (int i = 0; i < oldNumbers.length; i++) {
						if (!oldNumbers[i]) {
							if (subarray[i] - 1 <= 0)
								continue;
							subarray[i] = subarray[i] - 1;
							oldNumbers = markAndGetOldNumbers(subarray, oldNumbers, i);
							oldnums = getCountofOldNumbers(oldNumbers);
							step++;
							break;
						}
					}
				}
				System.out.println(step);
			}
		}
		long et = System.currentTimeMillis();
		System.out.println("Time taken:" + (et - st));
	}

	public static boolean[] markAndGetOldNumbers(Integer array[]) {
		int size = array.length;
		boolean isOldNumber[] = new boolean[size];
		for (int m = 0; m < size; m++) {
			int nn = array[m];
			isOldNumber[m] = isOldNumber(nn);
		}
		return isOldNumber;
	}

	public static boolean[] markAndGetOldNumbers(Integer[] subarray, boolean array[], int index) {
		int n = subarray[index];
		Boolean val = map.get(n);
		array[index] = (val != null) ? val : isOldNumber(n);
		return array;
	}

	public static int getCountofOldNumbers(boolean[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i])
				count++;
		}
		return count;
	}

	public static boolean isOldNumber(int n) {
		if (n % countOfOddNumbers(n) == 0) {
			map.put(n, true);
			return true;
		}
		return false;
	}

	public static int countOfOddNumbers(int n) {
		if (n % 2 == 0)
			return n / 2;
		return n / 2 + 1;
	}
}

class TestCase {
	public int testcaseNumber;
	public int arraySize;
	public Integer array[];
	public int tasks;
	public Integer[][] taskarray;

	public TestCase(int testcaseNumber, int arraySize, Integer[] array, int tasks, Integer[][] taskarray) {
		super();
		this.testcaseNumber = testcaseNumber;
		this.arraySize = arraySize;
		this.array = array;
		this.tasks = tasks;
		this.taskarray = taskarray;
	}

}
