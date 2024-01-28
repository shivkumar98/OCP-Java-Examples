package revision_notes.javaCode.chapter4;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class UsingSummaryStatistics {
	
	public static void main(String[] args) {
		IntStream i = IntStream.of(1,2,3,4);
		IntSummaryStatistics summary = i.summaryStatistics();
		System.out.println(summary.getAverage()); // 2.5
		System.out.println(summary.getMax()); // 4
		System.out.println(summary.getMin()); // 1
		
		
		IntStream empty = IntStream.empty();
		IntSummaryStatistics emptySummary = empty.summaryStatistics();
		System.out.println(emptySummary.getAverage()); // 0.0
		System.out.println(emptySummary.getMax());
	}

}
