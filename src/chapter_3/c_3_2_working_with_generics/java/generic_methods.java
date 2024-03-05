package chapter_3.c_3_2_working_with_generics.java;

public class generic_methods {
	public static <T> Crate<T> ship(T t){
		System.out.println("Preparing " + t);
		return new Crate<T>();
	}
}
