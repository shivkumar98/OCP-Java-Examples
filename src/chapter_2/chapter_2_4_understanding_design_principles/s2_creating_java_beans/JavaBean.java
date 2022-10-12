package chapter_2.chapter_2_4_understanding_design_principles.s2_creating_java_beans;
public class JavaBean {}

/* Q: What is a JavaBean?
 * A: JavaBean is another word for encapsulated Jaca class. A JavaBean is a design principle for encapsulating data in a object in java
 *    JavaBeans must obide certain properties
 *    
 * Rules for JavaBeans:
 * 1) properties are private
 * 2) getters for non boolean properties are prefixed with "get"
 * 3) getters for boolean properties may begin with "get" or "is"
 * 4) setters begin with "set"
 * 5) the first letter past the prefix of setter/getter is uppercase character of property
 */

/*	Suppose a class has the following properties:
 *  	private boolean playing;
 *  	private boolean dancing;
 *  Which of the following would be correctly defined in a JavaBean?
 *  1) public boolean isPlaying() { return playing; } - YES
 *  2) public boolean getPlaying() { return playing; } - YES
 *  3) public Boolean isDancing() { return dancing; } - NO, this is returning a wrapper class object so should be prefixed with "get"
 *  
 * 
 */
