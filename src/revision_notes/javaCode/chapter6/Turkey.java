package revision_notes.javaCode.chapter6;

public class Turkey implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("in close");
		throw new RuntimeException();
	}
	public static void main(String[] args) throws Exception {
		try(Turkey t = new Turkey()) {
			System.out.println("opening turkey");
		} 
	}

}
