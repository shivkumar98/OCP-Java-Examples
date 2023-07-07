package chapter_4.revision_notes;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Optionals {
	public static void main(String[] args) throws Exception {
		Consumer<Integer> c = System.out::print;
		Optional<Integer> x = Optional.empty();
		x.ifPresent(c); // nothing prints
		x = Optional.of(23);
		x.ifPresent(c); // 23
		
		Optional<Integer> empty = Optional.empty();
		Supplier<Integer> s = () -> 1;
		System.out.println(empty.orElseGet(s)); // 1
		Supplier<Exception> ex = IndexOutOfBoundsException::new;
		// empty.orElseThrow(s);// DOES NOT COMPILE
		empty.orElseThrow(ex); // THROWS EXCEPTION
	}
}
