package chapter_6.revisionNotes.javaCode;

import java.io.IOException;

public class TryWithResources {
	public static void main(String[] args) {
		try (ThrowsException te = new ThrowsException()){
			System.out.print("T");
		} catch (Exception e) {
			System.out.print("C");
		} finally {
			System.out.print("F");
		}
		// prints TICF
	}

}

class ThrowsException implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.print("I");
		throw new IOException();
	}
	
}
