package review_questions.chapter_1.attempt_6.java;

public class Q12 {

    static class Browser {
        public void go() {
            System.out.println("Inside Browser");
        }
    }
    static class Firefox extends Browser {
        public void go() {
            System.out.println("Inside Firefox");
        }
    }
    static class IE extends Browser {
        public void go() {
            System.out.println("Inside IE");
        }
    }
    
    public static void main(String[] args) {
		Browser b = new Browser();
		IE e = (IE) b;
		e.go(); // throws runtime exception
	}
	
}

