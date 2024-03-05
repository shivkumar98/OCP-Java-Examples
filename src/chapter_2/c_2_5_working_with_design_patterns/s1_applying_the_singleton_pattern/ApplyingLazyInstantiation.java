package chapter_2.c_2_5_working_with_design_patterns.s1_applying_the_singleton_pattern;

public class ApplyingLazyInstantiation {}

/* Q: What is lazy instantiation?
 * A: This is where we instantiate an object only when it is first retrieved
 */

// Example
class VisitorTicketTracker {
	private static VisitorTicketTracker instance;
	private VisitorTicketTracker() {}
	public static VisitorTicketTracker getInstance() {
		if (instance==null)
			instance = new VisitorTicketTracker(); // NOT THREAD SAFE!
		return instance;
	}
}

/* Lazy instantiation means instance is only created if requested by client
 * This reduces memory usage and increases performance
 * The issue with lazy instantiation is that it takes more time for a resource to be used the first time
 */

/* The above VisitorTickerTracker is not threadsafe
 * If two threads call the getInstance() method at the same time, then twoi instances are created but only one gets set fo rfuture threads
 * The two initial threads have DIFFERENT instances
 * We can rectify this issue by adding the syncronised keyword which means only one thread will be allowed in the method at a time
 * This ensures a single object is created 
 */

class VisitorTicketTrackerThreadSafe {
	private static VisitorTicketTrackerThreadSafe instance;
	private VisitorTicketTrackerThreadSafe() {}
	public synchronized static VisitorTicketTrackerThreadSafe getInstance() {
		if (instance==null)
			instance = new VisitorTicketTrackerThreadSafe(); // NOT THREAD SAFE!
		return instance;
	}
}
