package chapter_3.revision_notes_v2;

public class GenericClasses {
	public static void main(String[] args) {
		Crate<String> crate = new Crate();
		crate.packCrate("hello");
		System.out.println(crate.emptyCrate()); // hello
	}
	
	
}

class Crate<T> {
	private T contents;
	public T emptyCrate() {
		return contents;
	}
	void packCrate(T contents) {
		this.contents = contents;
	}
}