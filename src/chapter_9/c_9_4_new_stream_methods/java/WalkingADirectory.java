package chapter_9.c_9_4_new_stream_methods.java;

public class WalkingADirectory {
	
	// In chap 4 we saw all the useful methods in
	// the Streams API
	// We shall look at the first newly newly added NIO.2 stream based method
	// The Files.walk(path) method returns Stream<Path>
	// which traverses a dir in a depth-first, lazy manner
	// the child elements of the target is not loaded for performance
	// enhancements
	// means you can prodcess directories with a large number
	// of sub-directories
	public static void main(String[] args) {
		
	}
}
