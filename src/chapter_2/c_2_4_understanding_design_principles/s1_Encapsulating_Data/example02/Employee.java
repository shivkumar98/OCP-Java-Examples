package chapter_2.c_2_4_understanding_design_principles.s1_Encapsulating_Data.example02;

/* Consider the following class which is encapsulated.
 * We have no validation on the public methods, so in theory this would be equivalent to have a public field
 * But encapsulation IS actually better than leaving the field public!
 * Why?
 * Because we can change the implementation of this methods without forcing users to recompile their code
 * If we originally had the name a public field and then changed it to private => recompilation is required!
 */

public class Employee {
	
	private String name;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	

}
