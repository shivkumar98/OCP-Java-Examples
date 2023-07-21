package chapter_3.revision_notes;

import java.util.Comparator;

public class MethodReferences {
	Comparator<Duck> withoutLambda = new Comparator<Duck>() {
		public int compare(Duck o1, Duck o2) {
			return 0;
		}
	};
	
	Comparator<Duck> withLambda = (d1,d2) -> DuckHelper.byWeight(d1, d2);
	
	Comparator<Duck> withMethodRefs = DuckHelper::byWeight;

}

class DuckHelper {
	static int byWeight(Duck d1, Duck d2) {
		return d1.weight - d2.weight; 	}
	static int byName(Duck d1, Duck d2) {
		return d1.name.compareTo(d2.name);	}
}