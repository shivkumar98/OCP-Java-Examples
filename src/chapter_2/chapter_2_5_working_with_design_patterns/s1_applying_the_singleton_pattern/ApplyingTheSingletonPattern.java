package chapter_2.chapter_2_5_working_with_design_patterns.s1_applying_the_singleton_pattern;
public class ApplyingTheSingletonPattern {}

/* PROBLEM: How do we create an object only once in an application which is shared between multiple classes?
 * MOTIVATION: We may want to instantiate a class only once because the data is constrained to one instance
 * SOLUTION: Singleton Pattern
 *  - A globally accessible single instance is referred as a singleton
 *  - This can improve performance by loading reusable data vs the time required to store and reload data
 */
