package stef.dailycodingproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTransformation {

	/**
	 * This problem was asked by Uber.
	 * 
	 * Given an array of integers, return a new array such that each element at
	 * index i of the new array is the product of all the numbers in the original
	 * array except the one at i. For example, if our input was [1, 2, 3, 4, 5], the
	 * expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1],
	 * the expected output would be [2, 3, 6].
	 * 
	 * Follow-up: what if you can't use division?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Float> elements = new ArrayList<Float>();
		elements.add(1f);
		elements.add(2f);
		elements.add(3f);
		elements.add(0.5f);
		System.out.println(elements + " was transformed:");
		System.out.println("1) Transformation without division: " + arrayTransformationWithoutDivision(elements));
		System.out.println("2) Transformation with division: " + arrayTransformationWithDivision(elements));
	}

	public static List<Float> arrayTransformationWithoutDivision(List<Float> elements) {
		List<Float> result = new ArrayList<Float>();
		float before = 1;
		for(int i = 0; i < elements.size(); i++) {
			result.add(before);
			before *= elements.get(i);
		}
		float after = 1;
		for(int i = elements.size() - 1; i >= 0; i--) {
			result.set(i, result.get(i) * after);
			after *= elements.get(i);
		}
		return result;
	}
	
	public static List<Float> arrayTransformationWithDivision(List<Float> elements) {
		Float arrayMultiplication = elements.stream().reduce((a, b) -> a * b).orElseGet(() -> 1f);
		return elements.stream().map(x -> arrayMultiplication / x).collect(Collectors.toList());
	}
	
}
