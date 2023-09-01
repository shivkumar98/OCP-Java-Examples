package chapter_1.revision_notes;

public enum Restaurants {
	KFC(true), McDonalds(true), Starbucks(false),;
	public boolean servesChicken;
	private Restaurants(boolean servesChicken) {
		this.servesChicken = servesChicken;
	}
}
