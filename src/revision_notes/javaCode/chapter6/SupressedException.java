package revision_notes.javaCode.chapter6;

public class SupressedException {
	public static void main(String[] args) {
		try (Turkey t = new Turkey()) {
			throw new RuntimeException("inside try");
		} catch (Exception e) {
			System.out.println(e.getMessage()); // inside try 
			System.out.println(e.getSuppressed().length); // 1
		}
	}
}
