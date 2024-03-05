package chapter_4.c_4_2_workingWithBuiltInFunctionalInterfaces.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierInterface {
	

	public static void main(String[] args) {
		// The supplier interface is defines as:
		/*
		 * @FunctionalInterface
			class Supplier<T>() {
				public T get();
			}
		 */
		Supplier<LocalDate> s1 = LocalDate::now;
		Supplier<LocalDate> s2 = () -> LocalDate.now();
		
		LocalDate d1 = s1.get();
		LocalDate d2 = s2.get();
		
		System.out.println(d1); // 2023-05-25

		// What does the following code do?
		Supplier<ArrayList<String>> sb1 = ArrayList<String>::new;
		ArrayList<String> a1 = sb1.get();
		System.out.println(a1);
		// My guess: {}
		// actual: []
		
		// lets try printing out the supplier itself:
		System.out.println(sb1);
		// chapter_4.FunctionalInterfaces$$Lambda$44/0x0000000800113990@5ef60048

		
	}
}

