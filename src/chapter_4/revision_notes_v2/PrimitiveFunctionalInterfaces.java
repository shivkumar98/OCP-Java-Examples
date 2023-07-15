package chapter_4.revision_notes_v2;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

public class PrimitiveFunctionalInterfaces {
	
	public static void main(String[] args) {
		DoubleSupplier doubleSupplier = () -> .5;
		doubleSupplier.getAsDouble(); //0.5
		
		DoubleConsumer doubleConsumer = x -> System.out.println(x);;
		doubleConsumer.accept(1.3); // 1.3
		
		DoublePredicate doublePredicate = x -> x==1.3;
		System.out.println(doublePredicate.test(1)); // false
		System.out.println(doublePredicate.test(1.3)); // true
		
		DoubleFunction<String> doubleFunction = x -> ""+x;
		System.out.println(doubleFunction.apply(1.32).length()); // 4
		
		DoubleUnaryOperator doubleUnaryOperator = x -> x+1;
		System.out.println(doubleUnaryOperator.applyAsDouble(1.2)); // 2.2
		
		DoubleBinaryOperator doubleBinaryOperator = (x,y) -> x + y;
		System.out.println(doubleBinaryOperator.applyAsDouble(4.3, 5.6)); // 9.899999999999999

	}

}
