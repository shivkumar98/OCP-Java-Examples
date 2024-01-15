package revision_notes.javaCode.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsingImmutableClasses {
	public static void main(String[] args) {
		
		BadImmutableClass immutable = new BadImmutableClass(Arrays.asList("hello"));
		immutable.getList().remove(0);
		
		System.out.println(immutable.toString());
	}
}

final class ImmutableClass {
	private final int field;
	private final List<String> list;
	public ImmutableClass(int field, List<String> list) {
		this.field = field;
		this.list = new ArrayList<>(list);
	}
	public List getList() { // makes class immutable
		return new ArrayList<>(list);
	}
	@Override
	public String toString() {
		return "ImmutableClass [field=" + field + ", list=" + list + "]";
	}
	
	/* compiler error
	void setField(int field) {
		this.field = field;
	}
	*/
}

final class BadImmutableClass {
	private final List<String> list;
	public BadImmutableClass(List<String> list) {
		this.list = new ArrayList<>(list);
	}
	public List getList() { // makes class immutable
		return new ArrayList<>(list);
	}
	@Override
	public String toString() {
		return "BadImmutableClass [list=" + list + "]";
	}
}












