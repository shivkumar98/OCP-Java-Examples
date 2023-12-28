package revision_notes.javaCode.chapter6;

public class PuttingItTogether {
	public static void main(String[] args) {
		try (Turkey t = new Turkey()) {
			System.out.println("inside try");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("inside catch");
		}
	}
}
