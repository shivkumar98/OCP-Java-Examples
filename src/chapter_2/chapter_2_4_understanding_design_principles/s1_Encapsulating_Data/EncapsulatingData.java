package chapter_2.chapter_2_4_understanding_design_principles.s1_Encapsulating_Data;

/* Encapsulation is a fundamental design principle.
 * Q: What is encapsulation?
 * A: This is the idea of combining fields and methods in a class so that they operate on data and not direct user input
 * 	  This is achieved by using private instance members and public methods
 * 
 * Encapsulation means that the class has direct access to data and thus can invalidate incorrect data being supplied.
 * The class maintains INVARIANTS about its internal data,
 * 
 * E.g. suppose we deisgn an Animal class with the following design requirements:
 * 1) Each animal has a non-null, non-empty species field
 * 2) Each animal has an age >= 0
 * 
 * Example 1 will demonstrate encapsulation
 */

public class EncapsulatingData {}
