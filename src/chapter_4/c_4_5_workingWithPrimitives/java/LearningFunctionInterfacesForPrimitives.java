package chapter_4.c_4_5_workingWithPrimitives.java;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntToLongFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongToDoubleFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.stream.Stream;


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
		
		ToDoubleFunction<String> calculateLength = (String i)-> i.length() + i.replace("\\s+", "").length()*0.1;
		System.out.println(calculateLength.applyAsDouble(" hello shiv ")); // 13.2
		
		ToIntBiFunction<int[], Integer> countNumberOfTarget 
			= (arr, target)-> (int)Arrays.stream(arr).filter(i->i==target).count();
		System.out.println(countNumberOfTarget.applyAsInt(new int[]{1,1,2,1},3)); // 0
		System.out.println(countNumberOfTarget.applyAsInt(new int[]{1,1,2,1},1)); // 3
		
		DoubleToIntFunction truncate = i -> (int)i;
		System.out.println(truncate.applyAsInt(3.94)); // 3
		System.out.println(truncate.applyAsInt(-6.94)); // -6
		
		IntToLongFunction muliplyBy10ToPower9 = i -> i*(int)(Math.pow(10, 9));
		System.out.println(muliplyBy10ToPower9.applyAsLong(2)); // 2000000000
		System.out.println(muliplyBy10ToPower9.applyAsLong(3)); // -1294967296 overflow :(
		
		LongToDoubleFunction findAreaOfCircleWithRadius = i-> i*Math.PI;
		System.out.println(findAreaOfCircleWithRadius.applyAsDouble(1L)); // 3.141592653589793
		
		ObjIntConsumer<String> print = (s,i)-> System.out.println(s+i);
		ObjIntConsumer<Integer> print2 = (s,i)-> System.out.println(s+i);
		print.accept("shiv is aged: ", 25); // shiv is aged: 25
		print2.accept(23, 3); // 26

	}
}
