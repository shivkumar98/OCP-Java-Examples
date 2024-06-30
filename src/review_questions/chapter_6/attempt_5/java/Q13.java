package review_questions.chapter_6.attempt_5.java;

public class Q13 {
    static class SneezeException extends Exception { }
    static class SniffleException extends SneezeException { }
    public static void main(String[] args) throws SneezeException {
        try {
            throw new SneezeException();
        } catch (SneezeException | RuntimeException e) {
            
            throw e;
        }
    }

}
