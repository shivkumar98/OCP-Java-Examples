package chapter_6.revisionNotes.javaCode;

public class JammedTurkeyCage implements AutoCloseable {

	@Override
	public void close() throws IllegalStateException {
		throw new IllegalStateException("Cage door does not close");	
	}
	
	public static void main(String[] args) {
		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			throw new IllegalStateException("turkeys have run off");
		} catch (IllegalStateException e) {
			System.out.println("caught: " + e.getMessage());
			for (Throwable t: e.getSuppressed())
				System.out.println(t.getMessage());
		}
	}
}
