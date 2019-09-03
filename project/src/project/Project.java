/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author usufs
 */
public class Project {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int[] socks = {10, 20, 20, 10, 10, 30, 50, 10, 20};
		System.out.println(sockCouple(socks) + " Pasang kaos kaki");
//		int[] toys = {1, 12, 5, 111, 200, 1000, 10};
		int[] toys = {1,2,3,4};
		System.out.println(buyToys(toys, 7) + " buah mainan yang dibeli");
	}

	private static int sockCouple(int[] socks) {
		int sum = 0;
		List<Integer> hasCouple = new ArrayList<>();
		for (int i = 0; i < socks.length; i++) {
			if (socks.length - i + 1 > 0) {
				for (int j = i + 1; j < socks.length; j++) {
					if (!hasCouple.contains(i)) {
						if (socks[i] == socks[j]) {
							if (!hasCouple.contains(j)) {
								sum++;
								hasCouple.add(j);
							}
							break;
						}
					} else {
						break;
					}
				}
			}
		}
		return sum;
	}

	private static int buyToys(int[] toys, int money) {
		List<Integer> results = new ArrayList<>();
		int currentSum;
		int count;
		for (int i = 0; i < toys.length; i++) {
			currentSum = toys[i];
			count = 1;
			for (int j = 0; j < toys.length; j++) {
				if (i != j) {
					if (currentSum + toys[j] <= money) {
						currentSum = currentSum + toys[j];
						count++;
					}
				}
			}
			results.add(count);
		}
		Collections.sort(results, Collections.reverseOrder());
		return results.get(0);
	}
}
