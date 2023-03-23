package chapter_3.chapter_3_2_working_with_generics;

public class generic_methods {
	public static <T> Crate<T> ship(T t){
		System.out.println("Preparing " + t);
		return new Crate<T>();
	}
}
