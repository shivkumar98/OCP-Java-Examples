package revision_notes.javaCode.chapter1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Hippo {}
class Elephant {}
public class UsingInstanceOf {
	public static void main(String[] args) {
		System.out.println(null instanceof Hippo); // false
		Runnable nullElephant = new Thread();
		//nullElephant instanceof Hippo; // COMPILER ERROR
		Hippo hippo = new Hippo();
		boolean x = hippo instanceof Object;
		System.out.println(x);
		List l = new ArrayList();
		boolean y = l instanceof Hippo;
		System.out.println(l instanceof Object);
	}
}
