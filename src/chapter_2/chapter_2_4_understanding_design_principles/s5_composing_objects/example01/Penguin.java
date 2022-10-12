package chapter_2.chapter_2_4_understanding_design_principles.s5_composing_objects.example01;

public class Penguin {
	Flippers flipper;
	WebbedFeet webbedFeet;
	public Penguin() {
		this.flipper = new Flippers();
		this.webbedFeet = new WebbedFeet();
	}
	public void flap() { this.flipper.flap(); }
	public void kick() { this.webbedFeet.kick(); }
}

class Flippers {
	public void flap() { System.out.println("The flippers go back and forth"); }
}
class WebbedFeet {
	public void kick() { System.out.println("the webbed feet kick to and from"); }
}