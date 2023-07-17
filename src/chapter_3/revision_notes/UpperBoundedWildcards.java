package chapter_3.revision_notes;

import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcards {
public static long total(List<Number> list) {
	long count = 0;
	for (Number number: list)
		count += number.longValue();
	return count;
}
public static long totalUpperBounded(List<? extends Number> list) {
	long count = 0;
	for (Number number: list)
		count += number.longValue();
	return count;
}
public static void main(String[] args) {
	List<Integer> intList = Arrays.asList(1,2,3);
	List<Number> numList = Arrays.asList(1,2,3);
	// total(intList); // COMPILER ERROR
	totalUpperBounded(intList); // WORKS FINE
	total(numList); // WORKS FINE!
	totalUpperBounded(numList); // WORKS FINE!
}
}
