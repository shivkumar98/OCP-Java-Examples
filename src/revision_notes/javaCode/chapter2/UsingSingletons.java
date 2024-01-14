package revision_notes.javaCode.chapter2;

public class UsingSingletons {

}

class Singleton {
	private int field;
	private static Singleton instance = new Singleton();
	// private constructor:
	private Singleton(){}
	
	public static Singleton getInstance() {
		return instance;
	}
	
	public synchronized  void modifyField(int i) {
		this.field = i;
	}
}
