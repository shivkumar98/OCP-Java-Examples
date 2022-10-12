package chapter_2.chapter_2_4_understanding_design_principles.s3_applying_the_is_a_relationship;
public class IsARelationship {}

/*  Q: What is Is-a Relationship?
 *  We say that the instanceof operator can be used to determine if an object is an instance of the class, superclass or interface it implements
 *  
 *  A: The is-a test is used to determine if an object is a subclass of another class.
 *     It is also known as an inheritance test
 *     
 *  Knowing that A is-a B means we can TREAT A exactly as we TREAT B.
 *  This is very important when we decide the inheritance hierarchy between classes
 */

/* Suppose we have a Pet class: 
 * 		class Pet {}
 * 
 * We can then create a Cat subclass:
 * 		class Cat extends Pet {}
 * 
 * This is valid as Cat IS A Pet
 * We could also create a Tiger subclass:
 * 		class Tiger extends Pet {}
 * 
 * While this compiles, it violates the design principle. We can not treata Tiger object the same way we can treat a Pet
 * 
 * We can work around hierarchal relationships by using interfaces as a way to achieve multiple inheritance
 */
