package chapter_3.c_3_2_working_with_generics.java;

public class multiple_generic_types {
	public static void main(String[] args) {
		
		Elephant elephant = new Elephant();
		Integer numPounds = 15_000;
		SizeLimitedCrate<Elephant,Integer> crate = new SizeLimitedCrate(elephant, numPounds);
	}

}

class SizeLimitedCrate<T, U> {
	private T contents;
	private U sizeLimit;
	public SizeLimitedCrate(T contents, U sizeLimit) {
		this.contents = contents;
		this.sizeLimit = sizeLimit;
	}
}