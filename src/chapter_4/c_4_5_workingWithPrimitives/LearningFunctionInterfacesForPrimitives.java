package chapter_4.c_4_5_workingWithPrimitives;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongBinaryOperator;

public class LearningFunctionInterfacesForPrimitives {

	public static void main(String[] args) {
		IntFunction<Integer> square = i -> i*i;
		System.out.println(square.apply(3)); // 9
		
		DoubleUnaryOperator divideBy3 = i-> i/3;
		System.out.println(divideBy3.applyAsDouble(9.9)); // 3.3000000000000003
		
		LongBinaryOperator add = (i,j) -> (i+j);
		System.out.println(add.applyAsLong(1L, 2L)); // 3
		
		IntSupplier supplyRandom = ()-> (int)(Math.random()*100);
		System.out.println(supplyRandom.getAsInt()); // 42
		
		IntConsumer consumeRandom = i -> System.out.println(i);
		consumeRandom.accept(2); // 2
		
		DoublePredicate pred = i -> i%2==0;
		System.out.println(pred.test(2.0)); // true
		
		DoubleFunction<Integer> floor = i->(int)Math.floor(i); 
		System.out.println( floor.apply(3.2)); // 3
		
		
		
	}
}
