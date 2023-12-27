package revision_notes.javaCode.chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteCollections {
	
	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1,2,3);
//		for(int i:l1) // UnsupportedOperationException
//			l1.add(i);

		List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
		for(int i:l2) {
			System.out.print(i+" "); // 1 2 3
			l2.add(i);
		}
		System.out.println("\n"+l2); // [1,2,3,1,2,3]
		
		Set<Integer> s3 = new CopyOnWriteArraySet<>();
		s3.addAll(l2);
		for(int i:s3) {
			System.out.print(i+ " "); // 1 2 3
			s3.add(4);
		}
		System.out.println("\n"+s3); // [1,2,3,4]
	}

}
