package revision_notes.javaCode.chapter1;

public class WorkingWithEnums {

}

enum Animals {
	DOG(true), FISH(false);
	public boolean hasHair;
	Animals(boolean hasHair) { this.hasHair = hasHair; }
}

enum SeasonsAbstract {
	WINTER {
		public void printHours() {
			
		}
	};
	public abstract void printHours();
	
}